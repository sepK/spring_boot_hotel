package com.ecjtu.kongtao.bean;

/**
 * @author sepK
 */
public class OrderInfo {
    /**订单id*/
    private Integer orderId;
    /**房间id*/
    private Integer roomId;
    /**用户id*/
    private Integer userId;
    /**订单状态*/
    private Integer orderStatus;
    /**操作员工id*/
    private Integer empId;
    /**备注*/
    private String introduce;

    /**非入库字段 用户*/
    private User user;
    /**非入库字段 房间*/
    private Room room;
    /**非入库字段 员工*/
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
}