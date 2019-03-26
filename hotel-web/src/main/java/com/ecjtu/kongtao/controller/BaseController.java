package com.ecjtu.kongtao.controller;


import com.ecjtu.kongtao.exception.UserException;
import com.ecjtu.kongtao.service.*;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author sepK
 * @date 2018/12/11 11:42
 */
@ControllerAdvice
public class BaseController {
    @Resource
    protected AdminService adminService;
    @Resource
    protected CommentService commentService;
    @Resource
    protected UserService userService;
    @Resource
    protected EmployeeService employeeService;
    @Resource
    protected OrderInfoService orderInfoService;
    @Resource
    protected RoomService roomService;
    @Resource
    protected HousingService housingService;

    @ExceptionHandler
    @ResponseBody
    public Result exception(Exception exp) {
        if (exp instanceof UserException) {
            UserException userException = (UserException) exp;
            if (userException.getErrorCode() != null) {
                return Result.fail(userException.getErrorCode());
            }
        }
        return Result.fail();
    }
}
