package com.ecjtu.kongtao.bean.employee;

import java.io.Serializable;

/**
 * @author t.k
 * @date 2019/2/22 15:16
 */
public enum EmployeeType implements Serializable{
    /**前台收银员*/
    NORMAL_ROOM("前台收银员",1),
    /**服务员*/
    SINGLE_ROOM("服务员",2),
    /**前台经理*/
    BIG_BED_ROOM("前台经理",3),
    /**领班*/
    DELUXE_ROOM("领班",4),
    /**杂工*/
    SUITE("杂工",5),
    /**清洁员*/
    BUSINESS_ROOM("清洁员",6),
    /**总经理*/
    VP("总经理",7),
    ;

    private String desc;
    private int type;


    EmployeeType(String desc , int type){
        this.desc = desc;
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public int getType() {
        return type;
    }
}
