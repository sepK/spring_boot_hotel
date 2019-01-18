package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.UserComment;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
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
        PageHelper.startPage(pn,10);
        List<UserComment> list = commentService.getComments();
        PageInfo<UserComment> pageInfo = new PageInfo<>(list,5);
        return Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getComment(@PathVariable("id") String id){
        UserComment comment = commentService.getComment(id);
        return Result.success().add("comment", comment);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delComment(@PathVariable("id") String id){
        if (commentService.delComment(id)) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result saveComment(@PathVariable("id") Integer id, UserComment comment) {
        if (commentService.saveComment(comment)) {
            return Result.success();
        }else{
            return Result.fail();
        }

    }
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Result addComment(UserComment comment){
        return  commentService.addComment(comment);
    }

    @RequestMapping(value = "/searchComments", method = RequestMethod.GET)
    @ResponseBody
    public Result searchComments(@RequestParam("cusname") String cusname) {
        List<UserComment> comments = commentService.searchComments(cusname);
        return Result.success().add("comments", comments);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
