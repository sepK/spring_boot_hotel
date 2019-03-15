package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.comment.UserComment;
import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.user.User;
import com.ecjtu.kongtao.config.ConfigKey;
import com.ecjtu.kongtao.exception.UserException;
import com.ecjtu.kongtao.utils.ErrorCode;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public Result getComments(@RequestParam("pn") Integer pn, HttpServletRequest request) {
        PageHelper.startPage(pn, ConfigKey.DEFAULT_PAGE_SIZE);
        List<UserComment> userComments = commentService.getAllComments();
        PageInfo<UserComment> pageInfo = new PageInfo<>(userComments, ConfigKey.NAVIGATE_PAGE);
        return Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserComment(@PathVariable("commentId") Integer commentId){
        UserComment comment = commentService.getCommentById(commentId);
        comment.setUser(userService.getUser(comment.getUserId()));
        comment.setRoom(roomService.getRoom(comment.getRoomId()));
        return Result.success().add("comment", comment);
    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delUserComment(@PathVariable("commentId") Integer commentId) {
        commentService.delUserCommentById(commentId);
        return Result.success();
    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.PUT)
    @ResponseBody
    public Result saveUserComment(@PathVariable("commentId") Integer commentId, UserComment comment) {
        commentService.saveUserComment(comment);
        return Result.success();
    }
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Result addUserComment(@RequestParam("roomNumber") String roomNumber, @RequestParam("userName") String userName, UserComment comment){
        List<Room> rooms = roomService.searchRoomByRoomNumber(roomNumber);
        if (rooms.size() <= 0) {
            throw new UserException(ErrorCode.ERROR_ROOM_NOT_EXIST);
        }
        List<User> users = userService.searchUser(userName);
        if (users.size() <= 0) {
            throw new UserException(ErrorCode.ERROR_USER_NOT_EXIST);
        }
        return  commentService.addUserComment(comment, rooms.get(0), users.get(0));
    }

    @RequestMapping(value = "/searchComments", method = RequestMethod.GET)
    @ResponseBody
    public Result searchComments(@RequestParam("userName") String userName) {
        List<UserComment> comments = commentService.searchUserComments(userName);
        if (ObjectUtils.isEmpty(comments)) {
            return Result.fail(ErrorCode.ERROR_USER_NOT_COMMENT);
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
