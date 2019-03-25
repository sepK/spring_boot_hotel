package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.room.Room;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepKL
 */
@Service
public interface RoomService {

    /**
     * 获取所有房间信息
     *
     * @return 房间信息列表
     */
    List<Room> getRooms();

    /**
     * 通过主键id获取房间
     *
     * @param roomId 主键id
     * @return 房间信息
     */
    Room getRoom(Integer roomId);

    /**
     * 更新房间信息
     *
     * @param room 房间信息
     */
    void updateRoom(Room room);

    /**
     * 添加房间信息
     *
     * @param room 房间信息
     */
    void addRoom(Room room);

    /**
     * 检查房间是否存在
     *
     * @param roomNumber 房间号
     * @return true or false
     */
    boolean checkRoomNumber(String roomNumber);

    /**
     * 通过主键id删除房间
     *
     * @param id 主键id
     */
    void delRoom(Integer id);

    /**
     * 通过房间号查询房间
     *
     * @param roomNumber 房间号
     * @return 房间信息
     */
    List<Room> searchRoomByRoomNumber(String roomNumber);

    /**
     * 通过房间状态搜索房间
     *
     * @param status 房间状态
     * @return 房间列表
     */
    List<Room> getRoomByStatus(short status);

}
