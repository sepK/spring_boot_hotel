package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.Indent;
import com.ecjtu.kongtao.bean.OrderInfo;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface OrderInfoService {
    /**
     * 获取所有订单信息
     * @return 订单信息列表
     */
    List<OrderInfo> getOrders();

    /**
     * 通过id获取订单
     * @param id
     * @return
     */
    OrderInfo getOrder(Integer id);

    /**
     * 更新订单信息
     * @param orderInfo 订单信息
     * @return
     */
    void updateOrder(OrderInfo orderInfo);

    /**
     * 添加订单信息
     * @param orderInfo 订单信息
     */
    void addOrder(OrderInfo orderInfo);

    List<OrderInfo> getOrdersByRoomId(Integer roomId);

    boolean delOrder(Integer id);

    Result addIndent(Integer roomId, Indent indent);

    List<Indent> getIndents(String cusname);

    Result updateIndent(OrderInfo orderInfo);
}
