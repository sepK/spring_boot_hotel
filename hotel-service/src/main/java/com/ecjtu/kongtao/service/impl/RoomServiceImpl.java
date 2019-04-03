package com.ecjtu.kongtao.service.impl;


import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.room.RoomExample;
import com.ecjtu.kongtao.bean.room.RoomExample.Criteria;
import com.ecjtu.kongtao.mapper.RoomMapper;
import com.ecjtu.kongtao.service.RoomService;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author sepK
 */
@Service
@CacheConfig(cacheNames = "room")
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;

    @Override
    @Cacheable(key = "'all'")
    public List<Room> getRooms() {
        return roomMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    @Cacheable(key = "#roomId")
    public Room getRoom(Integer roomId) {
        return roomMapper.selectByPrimaryKey(roomId);
    }

    @Override
    @Caching(put = @CachePut(key = "#room.roomId"), evict = @CacheEvict(key = "'all'", allEntries = true))
    public void updateRoom(Room room) {
        roomMapper.updateByPrimaryKeySelective(room);
    }

    @Override
    @Caching(evict = @CacheEvict(key = "'all'", allEntries = true))
    public void addRoom(Room room) {
        Date now = new Date();
        room.setCreateTime(now);
        room.setLastModifyTime(now);
        roomMapper.insert(room);
    }

    @Override
    @Cacheable(key = "'check' + #roomNumber")
    public boolean checkRoomNumber(String roomNumber) {
        RoomExample example = new RoomExample();
        Criteria criteria = example.createCriteria();
        criteria.andRoomNumberEqualTo(roomNumber);
        return roomMapper.selectByExample(example).size() == 0;
    }

    @Override
    @Caching(evict = {@CacheEvict(key = "#roomId", allEntries = true), @CacheEvict(key = "'all")})
    public void delRoom(Integer roomId) {
        roomMapper.deleteByPrimaryKey(roomId);
    }

    @Override
    @Cacheable(key = "'search' + #roomNumber")
    public List<Room> searchRoomByRoomNumber(String roomNumber) {
        RoomExample example = new RoomExample();
        Criteria criteria = example.createCriteria();
        criteria.andRoomNumberEqualTo(roomNumber);
        return roomMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    @Cacheable(key = "'get' + #status")
    public List<Room> getRoomByStatus(short status) {
        RoomExample example = new RoomExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return roomMapper.selectByExampleWithBLOBs(example);
    }

}
