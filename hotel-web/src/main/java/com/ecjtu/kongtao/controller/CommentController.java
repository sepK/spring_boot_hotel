package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.UserComment;
import com.ecjtu.kongtao.utils.ConfigKey;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author sepK
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController{


    @RequestMapping("/index05")
    public String toIndex(){
        return "index05";
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseBody
    public Result getComments(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn, ConfigKey.DEFAULT_PAGE_SIZE);
        List<UserComment> userComments = commentService.getAllComments();
        PageInfo<UserComment> pageInfo = new PageInfo<>(userComments, ConfigKey.NAVIGATE_PAGE);
        return Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserComment(@PathVariable("id") String id){
        UserComment comment = commentService.getCommentById(id);
        return Result.success().add("comment", comment);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delUserComment(@PathVariable("id") String id){
        commentService.delUserCommentById(id);
        return Result.success();
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result saveUserComment(@PathVariable("id") Integer id, UserComment comment) {
        commentService.saveUserComment(comment);
        return Result.success();
    }
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Result addUserComment(UserComment comment){
        return  commentService.addUserComment(comment);
    }

    @RequestMapping(value = "/searchComments", method = RequestMethod.GET)
    @ResponseBody
    public Result searchComments(@RequestParam("userName") String userName) {
        List<UserComment> comments = commentService.searchUserComments(userName);
        if (ObjectUtils.isEmpty(comments)) {
            return Result.fail("用户没有评论");
        }
        return Result.success().add("comments", comments);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
