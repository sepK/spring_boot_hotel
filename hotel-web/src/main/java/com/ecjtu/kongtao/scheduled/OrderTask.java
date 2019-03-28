package com.ecjtu.kongtao.scheduled;

import com.ecjtu.kongtao.bean.order.OrderInfo;
import com.ecjtu.kongtao.bean.order.OrderStatus;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.HousingService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author t.k
 * @date 2019/3/20 17:55
 */
@Service
public class OrderTask extends BaseService {

    @Resource
    private HousingService housingService;
    /**
     * 十分钟
     */
    private static final int TEN_MINUTE = 10 * 60 * 1000;

    @Scheduled(cron = "0 0/30 * * * ?")
    public void checkOrder() {
        List<OrderInfo> orderInfos = orderInfoMapper.selectByExample(null);
        Date now = new Date();
        orderInfos.forEach(orderInfo -> {
            if (orderInfo.getOrderStatus() == OrderStatus.BOOKED.getStatus() && orderInfo.getCreateTime().getTime() > now.getTime() - TEN_MINUTE) {
                orderInfo.setOrderStatus(OrderStatus.CANCEL_ORDER.getStatus());
            } else if (orderInfo.getOrderStatus() == OrderStatus.CHECK_IN.getStatus()) {
                if (orderInfo.getEndTime().getTime() >= now.getTime()) {
                    orderInfo.setOrderStatus(OrderStatus.FINISH.getStatus());
                }
            }
            orderInfoMapper.updateByPrimaryKey(orderInfo);
        });

        System.out.println(now.getTime());
    }
}
