package com.ecjtu.kongtao.bean.housing;

import com.ecjtu.kongtao.bean.order.OrderInfo;

import java.io.Serializable;

/**
 * @author sepK
 */
public class Indent implements Serializable {
    /**
     * 订单信息
     */
    private OrderInfo orderInfo;
    /**
     * 入住信息
     */
    private Housing housing;
    /**
     * 照片地址
     */
    private String picture;

    public Indent() {
    }

    public Indent(OrderInfo orderInfo, Housing housing, String picture) {
        this.orderInfo = orderInfo;
        this.housing = housing;
        this.picture = picture;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
