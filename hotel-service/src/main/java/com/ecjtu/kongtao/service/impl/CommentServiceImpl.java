package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.UserComment;
import com.ecjtu.kongtao.bean.UserCommentExample;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.CommentService;
import com.ecjtu.kongtao.service.CustomerService;
import com.ecjtu.kongtao.service.RoomService;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sepK
 */
@Service
public class CommentServiceImpl extends BaseService implements CommentService {
    @Resource
    private CustomerService customerService;
    @Resource
    private RoomService roomService;

    @Override
    public List<UserComment> getComments() {
        return userCommentMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public UserComment getComment(String id) {
        return userCommentMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public boolean delComment(String id) {
        return userCommentMapper.deleteByPrimaryKey(Integer.valueOf(id)) > 0;
    }

    @Override
    public boolean saveComment(UserComment comment) {
        return userCommentMapper.updateByPrimaryKeySelective(comment) > 0;
    }

    @Override
    public Result addComment(UserComment comment) {
        String msg = null;
       /* comment.setId(UUID.randomUUID().toString().substring(0,10));
        try {
            if(roomService.checkRoomNumber(comment.getRoomNumber())){
               throw new RoomNotFoundException("房间不存在");
            }else{
                if(customerService.checkName(comment.getCusname())){
                  throw new CustomerNotFoundException("用户不存在");
                }else{
                    commentMapper.insert(comment);
                    return Result.success();
                }
            }
        } catch (RoomNotFoundException rnfe) {
            msg = rnfe.getMessage();
        } catch (CustomerNotFoundException cnfe) {
            msg = cnfe.getMessage();
        } catch (Exception e) {
            msg = e.getMessage();
        }*/
        return Result.fail(msg);
    }

    @Override
    public List<UserComment> searchComments(String userName) {
        UserCommentExample example = new UserCommentExample();
        UserCommentExample.Criteria criteria = example.createCriteria();
        //todo
        criteria.andUserIdEqualTo(1);
        return userCommentMapper.selectByExampleWithBLOBs(example);
    }
}
