package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.Admin;
import com.ecjtu.kongtao.service.AdminService;
import com.ecjtu.kongtao.utils.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/adminLogin")
    @ResponseBody
    public Msg checkAdminInfo(Admin admin, HttpServletRequest httpServletRequest){
        if(adminService.checkInfo(admin)){
            httpServletRequest.getSession().setAttribute("loginUser", admin);
            return Msg.success();
        }
        return Msg.fail();
    }
    @RequestMapping("/index07")
    public String toIndex(){
        return "/admin/index07";
    }

}
