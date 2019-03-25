package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.comment.UserComment;
import com.ecjtu.kongtao.bean.comment.UserCommentExample;
import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.user.User;
import com.ecjtu.kongtao.bean.user.UserExample;
import com.ecjtu.kongtao.exception.UserException;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.CommentService;
import com.ecjtu.kongtao.service.RoomService;
import com.ecjtu.kongtao.service.UserService;
import com.ecjtu.kongtao.utils.ErrorCode;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author sepK
 */
@Service
public class CommentServiceImpl extends BaseService implements CommentService {
    @Resource
    private UserService userService;
    @Resource
    private RoomService roomService;

    @Override
    public List<UserComment> getAllComments() {
        return userCommentMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public UserComment getCommentById(Integer commentId) {
        return userCommentMapper.selectByPrimaryKey(commentId);
    }

    @Override
    public void delUserCommentById(Integer commentId) {
        userCommentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public void saveUserComment(UserComment comment) {
        userCommentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public Result addUserComment(UserComment comment, Room room, User user) {
        if (roomService.checkRoomNumber(room.getRoomNumber())) {
            throw new UserException(ErrorCode.ERROR_HOUSE_NOT_EXIST);
        } else {
            if (userService.checkUserById(user.getUserId())) {
                throw new UserException(ErrorCode.ERROR_USER_NOT_EXIST);
            } else {
                comment.setRoomId(room.getRoomId());
                comment.setUserId(user.getUserId());
                comment.setCreateTime(new Date());
                comment.setLastModifyTime(new Date());
                userCommentMapper.insert(comment);
                return Result.success();
            }
        }
    }

    @Override
    public List<UserComment> searchUserComments(String userName) {
        UserCommentExample example = new UserCommentExample();
        UserCommentExample.Criteria criteria = example.createCriteria();

        UserExample userExample = new UserExample();
        UserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);

        if (!ObjectUtils.isEmpty(users)) {
            criteria.andUserIdEqualTo(users.get(0).getUserId());
            return userCommentMapper.selectByExampleWithBLOBs(example);
        }
        return null;
    }
}
