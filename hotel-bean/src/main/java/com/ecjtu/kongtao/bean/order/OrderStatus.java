package com.ecjtu.kongtao.bean.order;

import java.io.Serializable;
import java.util.stream.Stream;

/**
 * @author t.k
 * @date 2019/2/22 15:39
 */
public enum OrderStatus implements Serializable {
    /**
     * 预定
     */
    BOOKED("预定", 1),
    /**
     * 入住
     */
    CHECK_IN("入住", 2),
    /**
     * 退房
     */
    CHECK_OUT("退房", 3),
    /**
     * 完成
     */
    FINISH("完成", 4),
    /**
     * 取消订单
     */
    CANCEL_ORDER("取消订单", 5),;

    private String desc;
    private int status;


    OrderStatus(String desc, int status) {
        this.desc = desc;
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public int getStatus() {
        return status;
    }

    public OrderStatus convertTo(int status) {
        return Stream.of(OrderStatus.values()).filter(orderStatus -> orderStatus.getStatus() == status).findAny().orElse(null);
    }
}
