package com.ecjtu.kongtao.bean;

/**
 * @author sepK
 */
public class Admin {
    /**管理员id*/
    private Integer adminId;
    /**管理员登录名*/
    private String adminName;
    /**管理员密码*/
    private String password;

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
}