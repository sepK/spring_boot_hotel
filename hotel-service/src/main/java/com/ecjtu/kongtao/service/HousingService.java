package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.housing.Housing;

import java.util.List;

/**
 * @author sepK
 */
public interface HousingService {
    /**
     * 获取所有入住信息
     *
     * @return 入住信息
     */
    List<Housing> getHousings();

    /**
     * 通过主键id获取入住信息
     *
     * @param housingId 入住id
     * @return 入住信息
     */
    Housing getHousing(Integer housingId);

    /**
     * 保存入住信息
     *
     * @param housing 入住信息
     */
    void saveHousing(Housing housing);

    /**
     * 添加入住信息
     *
     * @param housing 入住信息
     */
    void addHousing(Housing housing);

    /**
     * 删除入住信息
     *
     * @param housingId 入住id
     */
    void delHousing(Integer housingId);

    /**
     * 搜索入住信息
     *
     * @param userName 用户名
     * @return 入住信息
     */
    List<Housing> searchHousings(String userName);

    /**
     * 通过用户名和房间id 获取入住信息
     *
     * @param roomId 房间id
     * @param userId 用户名
     * @return 入住信息
     */
    Housing getHousingByUserIdAndRoomId(Integer roomId, Integer userId);
}
