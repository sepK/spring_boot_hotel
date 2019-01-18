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
    protected UserCommentMapper userCommentMapper;
    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected EmployeeMapper employeeMapper;
    @Autowired
    protected HousingMapper housingMapper;
    @Autowired
    protected OrderInfoMapper orderInfoMapper;
    @Autowired
    protected RoomMapper roomMapper;

}
