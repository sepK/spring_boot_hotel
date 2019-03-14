package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.comment.UserComment;
import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.user.User;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface CommentService {

    /**
     * 获取所有用户的评论
     * @return 评论列表
     */
    List<UserComment> getAllComments();

    /**
     * 通过主键获取评论
     * @param id 主键
     * @return 评论
     */
    UserComment getCommentById(Integer id);

    /**
     * 通过主键删除评论
     * @param id 主键
     */
    void delUserCommentById(Integer id);

    /**
     * 保存评论
     * @param comment bean
     */
    void saveUserComment(UserComment comment);

    /**
     * 添加评论
     * @param comment bean
     * @param roomNumber
     * @param userName @return Result
     */
    Result addUserComment(UserComment comment, Room roomNumber, User userName);

    /**
     * 搜索评论 根据用户名称
     * @param userName 用户名称
     * @return 用户评论集合
     */
    List<UserComment> searchUserComments(String userName);
}
