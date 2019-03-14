package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.housing.Housing;
import com.ecjtu.kongtao.bean.housing.HousingExample;
import com.ecjtu.kongtao.exception.UserException;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.HousingService;
import com.ecjtu.kongtao.service.RoomService;
import com.ecjtu.kongtao.service.UserService;
import com.ecjtu.kongtao.utils.ErrorCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sepK
 */
@Service
public class HousingServiceImpl extends BaseService implements HousingService{
    @Resource
    private RoomService roomService;
    @Resource
    private UserService userService;

    @Override
    public List<Housing> getHousings() {
        return housingMapper.selectByExample(null);
    }

    @Override
    public Housing getHousing(Integer id) {
        return housingMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveHousing(Housing housing) {
        if(housing.getEndTime().compareTo(housing.getStartTime()) <= 0){
            //"结束时间小于开始时间"
            throw new UserException(ErrorCode.ERROR_TIME_RANGE_ERROR);
        }else{
            housingMapper.updateByPrimaryKeySelective(housing);
        }
    }

    @Override
    public void addHousing(Housing housing) {
        housingMapper.insert(housing);
    }

    @Override
    public List<Housing> searchHousings(String userName) {
        HousingExample example = new HousingExample();
        HousingExample.Criteria criteria = example.createCriteria();
        return housingMapper.selectByExample(example);
    }

    @Override
    public Housing getHousingByUserNameAndRoomId(Integer roomId, String userName) {
        HousingExample example = new HousingExample();
        HousingExample.Criteria criteria = example.createCriteria();
        return housingMapper.selectByExample(example).get(0);
    }

    @Override
    public void delHousing(Integer id) {
        housingMapper.deleteByPrimaryKey(id);
    }

}
