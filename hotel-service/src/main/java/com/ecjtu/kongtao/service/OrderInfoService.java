package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.housing.Indent;
import com.ecjtu.kongtao.bean.order.OrderInfo;
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
     *
     * @return 订单信息列表
     */
    List<OrderInfo> getOrders();

    /**
     * 通过id获取订单
     *
     * @param orderId 订单id
     * @return 订单信息
     */
    OrderInfo getOrder(Integer orderId);

    /**
     * 更新订单信息
     *
     * @param orderInfo 订单信息
     */
    void updateOrder(OrderInfo orderInfo);

    /**
     * 添加订单信息
     *
     * @param orderInfo 订单信息
     */
    void addOrder(OrderInfo orderInfo);

    /**
     * 通过roomId获取订单信息
     *
     * @param roomId 房间id
     * @return 订单信息
     */
    List<OrderInfo> getOrdersByRoomId(Integer roomId);

    /**
     * 删除订单信息
     *
     * @param orderId 订单id
     * @return true or false
     */
    boolean delOrder(Integer orderId);

    /**
     * 添加入住信息
     *
     * @param roomId 房间id
     * @param indent 中间bean
     * @return result
     */
    Result addIndent(Integer roomId, Indent indent);

    /**
     * 获取入住信息
     *
     * @param userName 用户名
     * @return indent 中间bean
     */
    List<Indent> getIndents(String userName);

    /**
     * 更新入住信息
     *
     * @param orderInfo 订单信息
     * @return result
     */
    Result updateIndent(OrderInfo orderInfo);
}
