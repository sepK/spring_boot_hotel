package com.ecjtu.kongtao.mapper;

import com.ecjtu.kongtao.bean.comment.UserComment;
import com.ecjtu.kongtao.bean.comment.UserCommentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sepK
 */
@Repository
public interface UserCommentMapper {

    /**
     * 带条件的统计数量
     *
     * @param example
     * @return
     */
    long countByExample(UserCommentExample example);

    /**
     * 带条件的删除
     *
     * @param example
     * @return
     */
    int deleteByExample(UserCommentExample example);

    /**
     * 通过主键删除
     *
     * @param commentId
     * @return
     */
    int deleteByPrimaryKey(Integer commentId);

    /**
     * 插入一条评论
     *
     * @param userComment bean
     */
    void insert(UserComment userComment);

    /**
     * 有选择的插入（允许值为空）
     *
     * @param record
     * @return
     */
    int insertSelective(UserComment record);

    /**
     * 查询（可以查询到text属性）
     *
     * @param example
     * @return
     */
    List<UserComment> selectByExampleWithBLOBs(UserCommentExample example);

    /**
     * 带条件的查询
     *
     * @param example
     * @return
     */
    List<UserComment> selectByExample(UserCommentExample example);

    /**
     * 通过主键查询
     *
     * @param commentId
     * @return
     */
    UserComment selectByPrimaryKey(Integer commentId);

    /**
     * 有选择的更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    /**
     * 带text属性的任意条件更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    /**
     * 任意条件更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    /**
     * 通过主键更新（值允许为空）
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserComment record);

    /**
     * 通过主键更新（值允许为空，带text属性的）
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(UserComment record);

    /**
     * 通过主键更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserComment record);
}