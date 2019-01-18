package com.ecjtu.kongtao.mapper;

import com.ecjtu.kongtao.bean.UserComment;
import com.ecjtu.kongtao.bean.UserCommentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sepK
 */
@Repository
public interface UserCommentMapper {
    long countByExample(UserCommentExample example);

    int deleteByExample(UserCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(UserComment record);

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