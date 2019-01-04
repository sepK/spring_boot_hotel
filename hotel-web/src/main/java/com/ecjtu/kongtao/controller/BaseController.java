package com.ecjtu.kongtao.controller;


import com.ecjtu.kongtao.service.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author t.k
 * @date 2018/12/11 11:42
 */
public class BaseController {
    @Autowired
    protected AdminService adminService;
    @Autowired
    protected CommentService commentService;
    @Autowired
    protected CustomerService customerService;
    @Autowired
    protected EmployeeService employeeService;
    @Autowired
    protected IntakeService intakeService;
    @Autowired
    protected OrderInfoService orderInfoService;
    @Autowired
    protected PhotoService photoService;
    @Autowired
    protected RoomService roomService;
}
