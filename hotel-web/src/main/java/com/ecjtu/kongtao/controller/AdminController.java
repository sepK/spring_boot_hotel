package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.admin.Admin;
import com.ecjtu.kongtao.utils.ErrorCode;
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
public class AdminController extends BaseController {

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/index07")
    public String toIndex() {
        return "/admin/index07";
    }

    @RequestMapping("/adminLogin")
    @ResponseBody
    public Result checkAdminInfo(Admin admin, HttpServletRequest httpServletRequest) {
        if (adminService.checkInfo(admin)) {
            httpServletRequest.getSession().setAttribute(SessionKey.ADMIN_USER, admin);
            return Result.success();
        }
        return Result.fail(ErrorCode.ERROR_PARAM_LOGIN);
    }

}
