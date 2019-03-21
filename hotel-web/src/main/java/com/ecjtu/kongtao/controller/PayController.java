package com.ecjtu.kongtao.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.ecjtu.kongtao.bean.order.OrderInfo;
import com.ecjtu.kongtao.bean.pay.AlipayVo;
import com.ecjtu.kongtao.bean.room.RoomType;
import com.ecjtu.kongtao.config.AlipayConfig;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author t.k
 * @date 2019/3/14 16:47
 */
@Controller
@RequestMapping("/alipay")
public class PayController extends BaseController {

    @GetMapping("pay")
    @ResponseBody
    private String pay(OrderInfo orderInfo) throws AlipayApiException {
        AlipayVo alipayVo = new AlipayVo();
        OrderInfo order = orderInfoService.getOrder(orderInfo.getOrderId());
        alipayVo.setOut_trade_no(order.getOrderNumber());
        alipayVo.setTotal_amount(order.getCostMoney().toString());
        alipayVo.setSubject(RoomType.conventToRoomType(order.getRoom().getType()).getDesc());
        //这个是固定的
        alipayVo.setProduct_code("FAST_INSTANT_TRADE_PAY");
        String json = new Gson().toJson(alipayVo);
        System.out.println(json);

        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAY_URL, AlipayConfig.APP_ID, AlipayConfig.MERCHANT_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.RETURN_URL);
        alipayRequest.setNotifyUrl(AlipayConfig.NOTIFY_URL);
        alipayRequest.setBizContent(json);
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println(result);
        //这里生成一个表单，会自动提交
        return result;
    }

    /**
     * @Title: alipayNotify
     * @Description: 支付宝回调接口
     * @author nelson
     * @param request
     * @param out_trade_no 商户订单号
     * @param trade_no 支付宝交易凭证号
     * @param trade_status 交易状态
     * @throws AlipayApiException
     * @return String
     * @throws
     */
    @PostMapping(value = "notify")
    private String notify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status)
            throws AlipayApiException {
        Map<String, String> map = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        requestParams.forEach((key, values) -> {
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                System.out.println(valueStr);
            }
            map.put(key, valueStr);
        });
        boolean signVerified;
        try {
            signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            // 验签发生异常,则直接返回失败
            return ("fail");
        }
        if (signVerified) {
            List<OrderInfo> orders = orderInfoService.getOrders();
            OrderInfo info = orders.stream().filter(orderInfo -> orderInfo.getOrderNumber().equals(out_trade_no)).findAny().orElse(null);
            if (ObjectUtils.isEmpty(info)) {
                return ("fail");
            } else {
                info.setOrderStatus(Integer.valueOf(trade_status));
                orderInfoService.updateIndent(info);
                return ("success");
            }

        } else {
            System.out.println("验证失败,不去更新状态");
            return ("fail");
        }
    }

    /**
     * @Title: alipayReturn
     * @Description: 支付宝回调接口
     * @author nelson
     * @param request
     * @param out_trade_no 商户订单号
     * @param trade_no 支付宝交易凭证号
     * @throws AlipayApiException
     * @return String
     * @throws
     */
    @GetMapping(value = "return")
    private String returnUrl(Map<String, String> params, HttpServletRequest request, String out_trade_no,String trade_no,String total_amount)
            throws AlipayApiException {
        Map<String, String> map = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iterator = requestParams.keySet().iterator(); iterator.hasNext();) {
            String name = iterator.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            map.put(name, valueStr);
        }
        boolean signVerified;
        try {
            signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            //验签发生异常,则直接返回失败
            return ("fail");
        }
        if (signVerified) {
            return ("success");
        } else {
            System.out.println("验证失败,不去更新状态");
            return ("fail");
        }
    }
}
