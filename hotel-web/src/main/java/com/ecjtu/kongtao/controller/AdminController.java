package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.Admin;
import com.ecjtu.kongtao.utils.Result;
import com.ecjtu.kongtao.utils.SessionKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sepK
 */
@Controller
public class AdminController extends BaseController{

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/adminLogin")
    @ResponseBody
    public Result checkAdminInfo(Admin admin, HttpServletRequest httpServletRequest){
        if(adminService.checkInfo(admin)){
            httpServletRequest.getSession().setAttribute(SessionKey.USER, admin);
            httpServletRequest.getSession().setMaxInactiveInterval(60 * 5);
            return Result.success();
        }
        return Result.fail();
    }
    @RequestMapping("/index07")
    public String toIndex(){
        return "/admin/index07";
    }

}
