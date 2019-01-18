package com.ecjtu.kongtao.bean;

import java.io.Serializable;

public class Indent implements Serializable{
    private OrderInfo orderInfo;
    private Housing housing;
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
