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

    /**
     *  通过roomId获取订单信息
     * @param roomId
     * @return
     */
    List<OrderInfo> getOrdersByRoomId(Integer roomId);

    /**
     *  删除订单信息
     * @param id
     * @return
     */
    boolean delOrder(Integer id);

    /**
     * 添加入住信息
     * @param roomId
     * @param indent
     * @return
     */
    Result addIndent(Integer roomId, Indent indent);

    /**
     *  获取入住信息
     * @param userName 用户名
     * @return
     */
    List<Indent> getIndents(String userName);

    /**
     * 更新入住信息
     * @param orderInfo
     * @return
     */
    Result updateIndent(OrderInfo orderInfo);
}
