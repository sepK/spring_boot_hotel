package com.ecjtu.kongtao.service.impl;


import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.room.RoomExample;
import com.ecjtu.kongtao.bean.room.RoomExample.Criteria;
import com.ecjtu.kongtao.mapper.RoomMapper;
import com.ecjtu.kongtao.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sepK
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;

    @Override
    public List<Room> getRooms() {
        return roomMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public Room getRoom(Integer roomId) {
        return roomMapper.selectByPrimaryKey(roomId);
    }

    @Override
    public void updateRoom(Room room) {
        roomMapper.updateByPrimaryKeySelective(room);
    }

    @Override
    public void addRoom(Room room) {
        roomMapper.insert(room);
    }

    @Override
    public boolean checkRoomNumber(String number) {
        RoomExample example = new RoomExample();
        Criteria criteria = example.createCriteria();
        criteria.andRoomNumberEqualTo(number);
        return roomMapper.selectByExample(example).size() == 0;
    }

    @Override
    public void delRoom(Integer id) {
        roomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Room> searchRoomByRoomNumber(String roomNumber) {
        RoomExample example = new RoomExample();
        Criteria criteria = example.createCriteria();
        criteria.andRoomNumberEqualTo(roomNumber);
        return roomMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Room> getRoomByStatus(short status) {
        RoomExample example = new RoomExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return roomMapper.selectByExampleWithBLOBs(example);
    }

    @Deprecated
    @Transactional(rollbackFor = Exception.class)
    public List<Room> getPictures() {
        /*List<Picture> pictures = new ArrayList<>();
        List<Room> rooms = roomMapper.selectByExampleWithBLOBs(null);
        for (Room room:rooms) {
            List<Photo> photos = photoService.searchPhotos(room.getId());
            Picture picture = new Picture(room,photos);
            pictures.add(picture);
        }
        return pictures;*/
        return null;
    }

    @Deprecated
    @Transactional(rollbackFor = Exception.class)
    public List<Room> getEmptyRooms() {
        /*RoomExample roomExample = new RoomExample();
        Criteria criteria = roomExample.createCriteria();
        criteria.andStatusEqualTo(Short.valueOf("0"));
        List<Picture> pictures = new ArrayList<>();
        List<Room> rooms = roomMapper.selectByExampleWithBLOBs(roomExample);
        for (Room room:rooms) {
            List<Photo> photos = photoService.searchPhotos(room.getId());
            Picture picture = new Picture(room,photos);
            pictures.add(picture);
        }
        return pictures;*/
        return null;
    }
}
