package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.housing.Housing;

import java.util.List;

/**
 * @author sepK
 */
public interface HousingService {
    /**
     * 获取所有入住信息
     * @return
     */
    List<Housing> getHousings();

    /**
     *  通过主键id获取入住信息
     * @param housingId
     * @return
     */
    Housing getHousing(Integer housingId);

    /**
     *  保存入住信息
     * @param housing
     */
    void saveHousing(Housing housing);

    /**
     *  添加入住信息
     * @param housing
     */
    void addHousing(Housing housing);

    /**
     *  删除入住信息
     * @param housingId
     */
    void delHousing(Integer housingId);

    /**
     *  搜索入住信息
     * @param userName
     * @return
     */
    List<Housing> searchHousings(String userName);

    /**
     *  通过用户名和房间id 获取入住信息
     * @param roomId
     * @param userId
     * @return
     */
    Housing getHousingByUserIdAndRoomId(Integer roomId, Integer userId);
}
