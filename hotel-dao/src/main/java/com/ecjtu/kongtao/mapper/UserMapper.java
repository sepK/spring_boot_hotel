package com.ecjtu.kongtao.mapper;

import com.ecjtu.kongtao.bean.user.User;
import com.ecjtu.kongtao.bean.user.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sepK
 */
@Repository
public interface UserMapper {

    /**
     * 带条件的统计数量
     *
     * @param example
     * @return
     */
    long countByExample(UserExample example);

    /**
     * 带条件的删除
     *
     * @param example
     * @return
     */
    int deleteByExample(UserExample example);

    /**
     * 通过主键删除
     *
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 插入一条记录
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 有选择的插入（允许值为空）
     *
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 带条件的查询
     *
     * @param example
     * @return
     */
    List<User> selectByExample(UserExample example);

    /**
     * 通过主键查询
     *
     * @param userId
     * @return
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * 有选择的更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * 任意条件更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * 通过主键更新（值允许为空）
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 通过主键更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
}