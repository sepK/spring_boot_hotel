package com.ecjtu.kongtao.controller;


import com.ecjtu.kongtao.exception.UserException;
import com.ecjtu.kongtao.service.*;
import com.ecjtu.kongtao.utils.ErrorCode;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sepK
 * @date 2018/12/11 11:42
 */
@ControllerAdvice
public class BaseController {
    @Autowired
    protected AdminService adminService;
    @Autowired
    protected CommentService commentService;
    @Autowired
    protected UserService userService;
    @Autowired
    protected EmployeeService employeeService;
    @Autowired
    protected OrderInfoService orderInfoService;
    @Autowired
    protected RoomService roomService;

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
