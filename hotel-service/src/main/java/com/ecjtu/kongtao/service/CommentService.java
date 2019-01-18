package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.UserComment;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface CommentService {

    List<UserComment> getComments();

    UserComment getComment(String id);

    boolean delComment(String id);

    boolean saveComment(UserComment comment);

    Result addComment(UserComment comment);

    List<UserComment> searchComments(String cusName);
}
