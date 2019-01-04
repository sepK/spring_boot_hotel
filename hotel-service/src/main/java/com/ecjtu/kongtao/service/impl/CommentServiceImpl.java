package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.Comment;
import com.ecjtu.kongtao.bean.CommentExample;
import com.ecjtu.kongtao.exception.CustomerNotFoundException;
import com.ecjtu.kongtao.exception.RoomNotFoundException;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.CommentService;
import com.ecjtu.kongtao.service.CustomerService;
import com.ecjtu.kongtao.service.RoomService;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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
    public List<Comment> getComments() {
        return commentMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public Comment getComment(String id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean delComment(String id) {
        return commentMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean saveComment(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment) > 0;
    }

    @Override
    public Result addComment(Comment comment) {
        String msg = null;
        comment.setId(UUID.randomUUID().toString().substring(0,10));
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
        }
        return Result.fail(msg);
    }

    @Override
    public List<Comment> searchComments(String cusname) {
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andCusnameLike(cusname);
        return commentMapper.selectByExampleWithBLOBs(example);
    }
}
