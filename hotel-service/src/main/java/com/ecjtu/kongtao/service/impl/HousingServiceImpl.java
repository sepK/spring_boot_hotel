package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.housing.Housing;
import com.ecjtu.kongtao.bean.housing.HousingExample;
import com.ecjtu.kongtao.exception.UserException;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.HousingService;
import com.ecjtu.kongtao.service.RoomService;
import com.ecjtu.kongtao.service.UserService;
import com.ecjtu.kongtao.utils.ErrorCode;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sepK
 */
@Service
@CacheConfig(cacheNames = "housing")
public class HousingServiceImpl extends BaseService implements HousingService {
    @Resource
    private RoomService roomService;
    @Resource
    private UserService userService;

    @Override
    @Cacheable(key = "'all'")
    public List<Housing> getHousings() {
        return housingMapper.selectByExample(null);
    }

    @Override
    @Cacheable(key = "#housingId")
    public Housing getHousing(Integer housingId) {
        return housingMapper.selectByPrimaryKey(housingId);
    }

    @Override
    @Caching(put = @CachePut(key = "#housing.housingId"), evict = @CacheEvict(key = "'all'"))
    public void saveHousing(Housing housing) {
        if (housing.getEndTime().compareTo(housing.getStartTime()) <= 0) {
            throw new UserException(ErrorCode.ERROR_TIME_RANGE_ERROR);
        } else {
            housingMapper.updateByPrimaryKeySelective(housing);
        }
    }

    @Override
    @Caching(put = @CachePut(key = "#housing.housingId"), evict = @CacheEvict(key = "'all'"))
    public void addHousing(Housing housing) {
        housingMapper.insert(housing);
    }

    @Override
    @Cacheable(key = "'search' + #userName")
    public List<Housing> searchHousings(String userName) {
        HousingExample example = new HousingExample();
        HousingExample.Criteria criteria = example.createCriteria();
        return housingMapper.selectByExample(example);
    }

    @Override
    public Housing getHousingByUserIdAndRoomId(Integer roomId, Integer userId) {
        HousingExample example = new HousingExample();
        HousingExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdEqualTo(roomId);
        criteria.andUserIdEqualTo(userId);
        List<Housing> housings = housingMapper.selectByExample(example);
        return housings.size() > 0 ? housings.get(0) : null;
    }

    @Override
    @Caching(evict = {@CacheEvict(key = "#housingId"), @CacheEvict(key = "'all")})
    public void delHousing(Integer housingId) {
        housingMapper.deleteByPrimaryKey(housingId);
    }

}
