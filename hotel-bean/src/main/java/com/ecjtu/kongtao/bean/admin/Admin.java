package com.ecjtu.kongtao.bean.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sepK
 */
public class Admin implements Serializable{
    /**管理员id*/
    private Integer adminId;
    /**管理员登录名*/
    private String adminName;
    /**管理员密码*/
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 上次修改时间
     */
    private Date lastModifyTime;
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
}