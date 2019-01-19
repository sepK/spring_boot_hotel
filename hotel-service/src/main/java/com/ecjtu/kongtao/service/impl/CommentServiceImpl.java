package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.User;
import com.ecjtu.kongtao.bean.UserComment;
import com.ecjtu.kongtao.bean.UserCommentExample;
import com.ecjtu.kongtao.bean.UserExample;
import com.ecjtu.kongtao.exception.CustomerNotFoundException;
import com.ecjtu.kongtao.exception.RoomNotFoundException;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.CommentService;
import com.ecjtu.kongtao.service.RoomService;
import com.ecjtu.kongtao.service.UserService;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
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
    public UserComment getCommentById(String id) {
        return userCommentMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public void delUserCommentById(String id) {
        userCommentMapper.deleteByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public void saveUserComment(UserComment comment) {
        userCommentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public Result addUserComment(UserComment comment) {
        String msg;
        try {
            if (roomService.checkRoomNumber(comment.getRoom().getRoomNumber())) {
               throw new RoomNotFoundException("房间不存在");
            } else {
                if (userService.checkUserById(comment.getUserId())) {
                  throw new CustomerNotFoundException("用户不存在");
                } else {
                    userCommentMapper.insert(comment);
                    return Result.success();
                }
            }
        }  catch (Exception e) {
            msg = e.getMessage();
        }
        return Result.fail(msg);
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
