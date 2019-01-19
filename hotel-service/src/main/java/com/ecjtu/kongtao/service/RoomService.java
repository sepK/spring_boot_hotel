package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.Room;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepKL
 */
@Service
public interface RoomService {

    List<Room> getRooms();

    Room getRoom(Integer id);

    boolean saveRoom(Room room);

    boolean addRoom(Room room);

    /**
     * 检查房间是否存在
     * @param roomNumber 房间号
     * @return true or false
     */
    boolean checkRoomNumber(String roomNumber);

    boolean delRoom(Integer id);

    List<Room> searchRoomByRoomNumber(String roomNumber);

    List<Room> getRoomByStatus(short status);

}
