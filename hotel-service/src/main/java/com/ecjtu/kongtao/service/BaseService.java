package com.ecjtu.kongtao.service;

import com.ecjtu.kongtao.mapper.*;
import com.ecjtu.kongtao.utils.RedisUtils;

import javax.annotation.Resource;

/**
 * @author t.k
 * @date 2018/12/11 11:36
 */
public class BaseService {

    @Resource
    protected AdminMapper adminMapper;
    @Resource
    protected UserCommentMapper userCommentMapper;
    @Resource
    protected UserMapper userMapper;
    @Resource
    protected EmployeeMapper employeeMapper;
    @Resource
    protected HousingMapper housingMapper;
    @Resource
    protected OrderInfoMapper orderInfoMapper;
    @Resource
    protected RoomMapper roomMapper;
    @Resource
    protected RedisUtils redisUtils;

}
