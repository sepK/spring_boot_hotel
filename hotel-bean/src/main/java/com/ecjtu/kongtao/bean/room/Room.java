package com.ecjtu.kongtao.bean.room;

import java.io.Serializable;

/**
 * @author sepK
 */
public class Room implements Serializable {
    /**房间id*/
    private Integer roomId;
    /**房间号*/
    private String roomNumber;
    /**房间类型*/
    private Integer type;
    /**房间价格*/
    private Double price;
    /**房间状态*/
    private Short status;
    /**照片地址*/
    private String picture;
    /**房间简介*/
    private String introduce;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}