package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.Comment;
import com.ecjtu.kongtao.utils.Msg;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface CommentService {

    List<Comment> getComments();

    Comment getComment(String id);

    boolean delComment(String id);

    boolean saveComment(Comment comment);

    Msg addComment(Comment comment);

    List<Comment> searchComments(String cusName);
}
