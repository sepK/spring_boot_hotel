package com.ecjtu.kongtao.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * @author sepK
 */
public class Result {
    /**
     * 状态码   200-成功    400-失败
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 用户要返回给浏览器的数据
     */
    private Map<String, Object> extend = new HashMap<>();

    public static Result success() {
        Result result = new Result();
        result.setCode(ErrorCode.ERROR_SUCCESS.getCode());
        result.setMsg(ErrorCode.ERROR_SUCCESS.getMsg());
        return result;
    }

    public static Result success(ErrorCode errorCode) {
        Result result = new Result();
        result.setCode(errorCode.getCode());
        result.setMsg(errorCode.getMsg());
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setCode(ErrorCode.ERROR_PARA.getCode());
        result.setMsg(ErrorCode.ERROR_PARA.getMsg());
        return result;
    }

    public static Result fail(ErrorCode errorCode) {
        Result result = new Result();
        result.setCode(errorCode.getCode());
        result.setMsg(errorCode.getMsg());
        return result;
    }

    public Result add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
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

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

}
