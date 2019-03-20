package com.ecjtu.kongtao.bean.housing;

import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.user.User;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sepK
 */
public class Housing implements Serializable {
    /**入住id*/
    private Integer housingId;
    /**房间id*/
    private Integer roomId;
    /**用户id*/
    private Integer userId;
    /**开始时间*/
    private Date startTime;
    /**结束时间*/
    private Date endTime;
    /**支付金额*/
    private Double costMoney;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 上次修改时间
     */
    private Date lastModifyTime;

    /**非入库字段 用户*/
    private User user;
    /**非入库字段 房间*/
    private Room room;

    public Integer getHousingId() {
        return housingId;
    }

    public void setHousingId(Integer housingId) {
        this.housingId = housingId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(Double costMoney) {
        this.costMoney = costMoney;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}