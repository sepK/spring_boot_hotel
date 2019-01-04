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
    List<OrderInfo> getOrders();

    OrderInfo getOrder(Integer id);

    boolean saveOrder(OrderInfo orderInfo);

    boolean addOrder(OrderInfo orderInfo);

    List<OrderInfo> getOrdersByRoomId(Integer roomid);

    boolean delOrder(Integer id);

    Result addIndent(Integer roomId, Indent indent);

    List<Indent> getIndents(String cusname);

    Result updateIndent(OrderInfo orderInfo);
}
