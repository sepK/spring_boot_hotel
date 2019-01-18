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

    boolean checkRoomNumber(String number);

    boolean delRoom(Integer id);

    List<Room> searchRoomByRoomNumber(String roomNumber);

    List<Room> getRoomByStatus(short status);

}
