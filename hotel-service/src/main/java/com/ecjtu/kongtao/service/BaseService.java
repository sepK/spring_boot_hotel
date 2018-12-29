package com.ecjtu.kongtao.service;

import com.ecjtu.kongtao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author t.k
 * @date 2018/12/11 11:36
 */
public class BaseService {

    @Autowired
    protected AdminMapper adminMapper;
    @Autowired
    protected CommentMapper commentMapper;
    @Autowired
    protected CustomerMapper customerMapper;
    @Autowired
    protected EmployeeMapper employeeMapper;
    @Autowired
    protected IntakeMapper intakeMapper;
    @Autowired
    protected OrderInfoMapper orderInfoMapper;
    @Autowired
    protected PhotoMapper photoMapper;
    @Autowired
    protected RoomMapper roomMapper;

}
