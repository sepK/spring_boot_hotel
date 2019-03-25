package com.ecjtu.kongtao.bean.room;

import java.io.Serializable;
import java.util.stream.Stream;

/**
 * @author t.k
 * @date 2019/2/21 16:57
 */
public enum RoomType implements Serializable {
    /**
     * 标准间
     */
    NORMAL_ROOM("标准间", 1),
    /**
     * 单人间
     */
    SINGLE_ROOM("单人间", 2),
    /**
     * 大床间
     */
    BIG_BED_ROOM("大床间", 3),
    /**
     * 豪华间
     */
    DELUXE_ROOM("豪华间", 4),
    /**
     * 套间
     */
    SUITE("套间", 5),
    /**
     * 商务间
     */
    BUSINESS_ROOM("商务间", 6),;

    private String desc;
    private int type;


    RoomType(String desc, int type) {
        this.desc = desc;
        this.type = type;
    }

    public static RoomType conventToRoomType(int type) {
        return Stream.of(RoomType.values()).filter(roomType -> roomType.getType() == type).findAny().orElse(null);
    }

    public String getDesc() {
        return desc;
    }

    public int getType() {
        return type;
    }
}
