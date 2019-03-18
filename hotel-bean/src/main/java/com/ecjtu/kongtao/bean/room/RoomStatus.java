package com.ecjtu.kongtao.bean.room;

import java.io.Serializable;

/**
 * @author t.k
 * @date 2019/2/22 15:39
 */
public enum RoomStatus implements Serializable{
    /**空闲*/
    IDLE("空闲", 0),
    /**预定*/
    BOOKED("预定", 1),
    /**入住*/
    CHECK_IN("入住", 2),
    /**退房*/
    CHECK_OUT("退房", 3),
    ;

    private String desc;
    private int status;


    RoomStatus(String desc, int status){
        this.desc = desc;
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public int getStatus() {
        return status;
    }
}
