package com.ecjtu.kongtao.bean.comment;

import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.user.User;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sepK
 */
public class UserComment implements Serializable {
    /**
     * 评论id
     */
    private Integer commentId;
    /**
     * 评论人id
     */
    private Integer userId;
    /**
     * 房间id
     */
    private Integer roomId;
    /**
     * 评级等级
     */
    private Integer level;
    /**
     * 评论时间
     */
    private Date createTime;
    /**
     * 上次修改时间
     */
    private Date lastModifyTime;
    /**
     * 评论
     */
    private String comment;
    /**
     * 非入库字段 用户
     */
    private User user;
    /**
     * 非入库字段 房间
     */
    private Room room;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}