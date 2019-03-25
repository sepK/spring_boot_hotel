package com.ecjtu.kongtao.bean.order;

import com.ecjtu.kongtao.bean.employee.Employee;
import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.user.User;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sepK
 */
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 订单号
     */
    private String orderNumber;
    /**
     * 房间id
     */
    private Integer roomId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 操作员工id
     */
    private Integer empId;
    /**
     * 备注
     */
    private String introduce;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 入住 开始时间
     */
    private Date startTime;
    /**
     * 入住 结束时间
     */
    private Date endTime;
    /**
     * 消耗金额
     */
    private Double costMoney;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 上次修改时间
     */
    private Date lastModifyTime;

    /**
     * 非入库字段 用户
     */
    private User user;
    /**
     * 非入库字段 房间
     */
    private Room room;
    /**
     * 非入库字段 员工
     */
    private Employee employee;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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


}