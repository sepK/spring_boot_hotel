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
     * example
     * @param example
     * @return
     */
    long countByExample(UserCommentExample example);

    int deleteByExample(UserCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    /**
     * 插入一条评论
     * @param userComment bean
     */
    void insert(UserComment userComment);

    int insertSelective(UserComment record);

    List<UserComment> selectByExampleWithBLOBs(UserCommentExample example);

    List<UserComment> selectByExample(UserCommentExample example);

    UserComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    int updateByExample(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    int updateByPrimaryKeySelective(UserComment record);

    int updateByPrimaryKeyWithBLOBs(UserComment record);

    int updateByPrimaryKey(UserComment record);
}