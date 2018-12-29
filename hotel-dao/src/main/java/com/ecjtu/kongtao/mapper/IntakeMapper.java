package com.ecjtu.kongtao.mapper;

import com.ecjtu.kongtao.bean.Intake;
import com.ecjtu.kongtao.bean.IntakeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sepK
 */
@Repository
public interface IntakeMapper {
    long countByExample(IntakeExample example);

    int deleteByExample(IntakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Intake record);

    int insertSelective(Intake record);

    List<Intake> selectByExample(IntakeExample example);

    Intake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Intake record, @Param("example") IntakeExample example);

    int updateByExample(@Param("record") Intake record, @Param("example") IntakeExample example);

    int updateByPrimaryKeySelective(Intake record);

    int updateByPrimaryKey(Intake record);
}