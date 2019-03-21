package com.ecjtu.kongtao.mapper;

import com.ecjtu.kongtao.bean.admin.Admin;
import com.ecjtu.kongtao.bean.admin.AdminExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sepK
 */
@Repository
public interface AdminMapper {

    /**
     * 带条件的统计数量
     *
     * @param example
     * @return
     */
    long countByExample(AdminExample example);

    /**
     * 带条件的删除
     * @param example
     * @return
     */
    int deleteByExample(AdminExample example);

    /**
     * 通过主键删除
     * @param adminId
     * @return
     */
    int deleteByPrimaryKey(Integer adminId);

    /**
     * 插入一条记录
     * @param record
     * @return
     */
    int insert(Admin record);

    /**
     * 有选择的插入（允许值为空）
     * @param record
     * @return
     */
    int insertSelective(Admin record);

    /**
     * 带条件的查询
     * @param example
     * @return
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     * 通过主键查询
     * @param adminId
     * @return
     */
    Admin selectByPrimaryKey(Integer adminId);

    /**
     * 有选择的更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * 任意条件更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * 通过主键更新（值允许为空）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * 通过主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Admin record);
}