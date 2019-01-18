package com.ecjtu.kongtao.mapper;

import com.ecjtu.kongtao.bean.Housing;
import com.ecjtu.kongtao.bean.HousingExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sepK
 */
@Repository
public interface HousingMapper {
    long countByExample(HousingExample example);

    int deleteByExample(HousingExample example);

    int deleteByPrimaryKey(Integer housingId);

    int insert(Housing record);

    int insertSelective(Housing record);

    List<Housing> selectByExample(HousingExample example);

    Housing selectByPrimaryKey(Integer housingId);

    int updateByExampleSelective(@Param("record") Housing record, @Param("example") HousingExample example);

    int updateByExample(@Param("record") Housing record, @Param("example") HousingExample example);

    int updateByPrimaryKeySelective(Housing record);

    int updateByPrimaryKey(Housing record);
}