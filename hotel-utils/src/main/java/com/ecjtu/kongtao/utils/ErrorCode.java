package com.ecjtu.kongtao.utils;

/**
 * 错误码
 *
 * @author sepK
 * @date 2019/1/21 10:35
 */
public enum ErrorCode {
    /***************************通用异常**************************/
    /**
     * 返回成功
     */
    ERROR_SUCCESS(200, "处理成功"),
    /**
     * 请求错误
     */
    ERROR_PARA(400, "请求参数错误"),
    /**
     * 房间不存在
     */
    ERROR_HOUSE_NOT_EXIST(1, "请选择正确的房间"),
    /**
     * 用户不存在
     */
    ERROR_USER_NOT_EXIST(2, "请选择正确的用户"),
    /**
     * 用户没有评论
     */
    ERROR_USER_NOT_COMMENT(3, "用户评论为空"),
    /**
     * 房间不是空闲状态
     */
    ERROR_HOUSE_NOT_UNOCCUPIED(4, "房间不是空闲状态"),
    /**
     * 员工不存在
     */
    ERROR_EMPLOYEE_NOT_EXIST(5, "请选择在职的员工"),
    /**
     * 用户名或者密码错误
     */
    ERROR_PARAM_LOGIN(6, "请输入正确的用户名或密码"),
    /**
     * 房间不存在
     */
    ERROR_ROOM_NOT_EXIST(7, "请选择合适的房间"),
    /**
     * 时间范围不正确
     */
    ERROR_TIME_RANGE_ERROR(8, "请输入正确的时间"),;

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;

    ErrorCode(int code) {
        this.code = code;
    }

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
