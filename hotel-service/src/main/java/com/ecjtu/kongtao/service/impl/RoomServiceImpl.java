package com.ecjtu.kongtao.service.impl;


import com.ecjtu.kongtao.bean.Photo;
import com.ecjtu.kongtao.bean.Picture;
import com.ecjtu.kongtao.bean.Room;
import com.ecjtu.kongtao.bean.RoomExample;
import com.ecjtu.kongtao.bean.RoomExample.Criteria;
import com.ecjtu.kongtao.mapper.RoomMapper;
import com.ecjtu.kongtao.service.PhotoService;
import com.ecjtu.kongtao.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sepK
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;
    @Resource
    private PhotoService photoService;

    @Override
    public List<Room> getRooms() {
        return roomMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public Room getRoom(Integer id) {
        return roomMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean saveRoom(Room room) {
        return roomMapper.updateByPrimaryKeySelective(room) > 0;
    }

    @Override
    public boolean addRoom(Room room) {
        return roomMapper.insert(room) > 0;
    }

    @Override
    public boolean checkRoomNumber(String number) {
        RoomExample example = new RoomExample();
        Criteria criteria = example.createCriteria();
        criteria.andRoomNumberEqualTo(number);
        return roomMapper.selectByExample(example).size() == 0;
    }

    @Override
    public boolean delRoom(Integer id) {
        return roomMapper.deleteByPrimaryKey(id) > 0;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Picture> getPictures() {
        List<Picture> pictures = new ArrayList<Picture>();
        List<Room> rooms = roomMapper.selectByExampleWithBLOBs(null);
        for (Room room:rooms) {
            List<Photo> photos = photoService.searchPhotos(room.getId());
            Picture picture = new Picture(room,photos);
            pictures.add(picture);
        }
        return pictures;
    }

    @Override
    @Transactional
    public List<Picture> getEmptyRooms() {
        RoomExample roomExample = new RoomExample();
        Criteria criteria = roomExample.createCriteria();
        criteria.andStatusEqualTo(Short.valueOf("0"));
        List<Picture> pictures = new ArrayList<Picture>();
        List<Room> rooms = roomMapper.selectByExampleWithBLOBs(roomExample);
        for (Room room:rooms) {
            List<Photo> photos = photoService.searchPhotos(room.getId());
            Picture picture = new Picture(room,photos);
            pictures.add(picture);
        }
        return pictures;
    }
}
