package com.ecjtu.kongtao.mapper;

import com.ecjtu.kongtao.bean.housing.Housing;
import com.ecjtu.kongtao.bean.housing.HousingExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sepK
 */
@Repository
public interface HousingMapper {

    /**
     * 带条件的统计数量
     *
     * @param example
     * @return
     */
    long countByExample(HousingExample example);

    /**
     * 带条件的删除
     * @param example
     * @return
     */
    int deleteByExample(HousingExample example);

    /**
     * 通过主键删除
     * @param housingId
     * @return
     */
    int deleteByPrimaryKey(Integer housingId);

    /**
     * 插入一条记录
     * @param record
     * @return
     */
    int insert(Housing record);

    /**
     * 有选择的插入（允许值为空）
     * @param record
     * @return
     */
    int insertSelective(Housing record);

    /**
     * 带条件的查询
     * @param example
     * @return
     */
    List<Housing> selectByExample(HousingExample example);

    /**
     * 通过主键查询
     * @param housingId
     * @return
     */
    Housing selectByPrimaryKey(Integer housingId);

    /**
     * 有选择的更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Housing record, @Param("example") HousingExample example);

    /**
     * 任意条件更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Housing record, @Param("example") HousingExample example);

    /**
     * 通过主键更新（值允许为空）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Housing record);

    /**
     * 通过主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Housing record);
}