package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.employee.Employee;
import com.ecjtu.kongtao.bean.housing.Indent;
import com.ecjtu.kongtao.bean.order.OrderInfo;
import com.ecjtu.kongtao.bean.order.OrderInfoExample;
import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.user.User;
import com.ecjtu.kongtao.exception.UserException;
import com.ecjtu.kongtao.service.*;
import com.ecjtu.kongtao.utils.ErrorCode;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author sepK
 */
@Service
public class OrderInfoServiceImpl extends BaseService implements OrderInfoService {
    @Resource
    private RoomService roomService;
    @Resource
    private UserService userService;
    @Resource
    private EmployeeService employeeService;

    @Override
    public List<OrderInfo> getOrders() {
        List<OrderInfo> orderInfos = orderInfoMapper.selectByExampleWithBLOBs(null);
        orderInfos.forEach(orderInfo -> {
            User user = userMapper.selectByPrimaryKey(orderInfo.getUserId());
            if (!ObjectUtils.isEmpty(orderInfo.getEmpId()) && orderInfo.getEmpId() > 0) {
                Employee employee = employeeMapper.selectByPrimaryKey(orderInfo.getEmpId());
                orderInfo.setEmployee(employee);
            }
            Room room = roomService.getRoom(orderInfo.getRoomId());
            orderInfo.setUser(user);
            orderInfo.setRoom(room);
        });
        return orderInfos;
    }

    @Override
    public OrderInfo getOrder(Integer id) {
        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(id);
        User user = userMapper.selectByPrimaryKey(orderInfo.getUserId());
        if (!ObjectUtils.isEmpty(orderInfo.getEmpId()) && orderInfo.getEmpId() > 0) {
            Employee employee = employeeMapper.selectByPrimaryKey(orderInfo.getEmpId());
            orderInfo.setEmployee(employee);
        }
        Room room = roomService.getRoom(orderInfo.getRoomId());
        orderInfo.setUser(user);
        orderInfo.setRoom(room);
        return orderInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(OrderInfo orderInfo) {
        Room room = new Room();
        room.setRoomId(orderInfo.getRoomId());
        room.setStatus(Short.valueOf(orderInfo.getOrderStatus().toString()));
        roomService.updateRoom(room);
        User user = userService.getUser(orderInfo.getUser().getUserName());
        orderInfo.setUserId(user.getUserId());
        orderInfoMapper.updateByPrimaryKey(orderInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrder(OrderInfo orderInfo) {
        Room room = roomService.getRoom(orderInfo.getRoomId());
            if (room == null) {
                throw new UserException(ErrorCode.ERROR_PARA);
            } else if (room.getStatus() != 0) {
                throw new UserException(ErrorCode.ERROR_HOUSE_NOT_UNOCCUPIED);
            } else if (userService.checkUserById(orderInfo.getUserId())) {
                throw new UserException(ErrorCode.ERROR_USER_NOT_EXIST);
            } else if(orderInfo.getEmpId() != null && employeeService.getEmp(orderInfo.getEmpId()) == null) {
                throw new UserException(ErrorCode.ERROR_EMPLOYEE_NOT_EXIST);
            } else {
                room.setStatus(Short.valueOf(orderInfo.getOrderStatus().toString()));
                roomService.updateRoom(room);
                orderInfoMapper.insertSelective(orderInfo);
            }
    }

    @Override
    public List<OrderInfo> getOrdersByRoomId(Integer roomId) {
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdEqualTo(roomId);
        return orderInfoMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public boolean delOrder(Integer id) {
        return orderInfoMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Result addIndent(Integer roomId, Indent indent) {
        Date now = new Date();
        OrderInfo orderInfo = indent.getOrderInfo();
        orderInfo.setOrderStatus(Integer.valueOf("1"));
        orderInfo.setOrderNumber(now.getTime() + UUID.randomUUID().toString().replace("-", "").substring(1, 10));
        User user = userService.getUser(orderInfo.getUser().getUserName());
        if (ObjectUtils.isEmpty(user)) {
            throw new UserException(ErrorCode.ERROR_USER_NOT_EXIST);
        }
        orderInfo.setUserId(user.getUserId());
        orderInfo.setCreateTime(now);
        orderInfo.setLastModifyTime(now);
        orderInfo.setRoomId(roomId);
        orderInfoMapper.insertSelective(orderInfo);
        return Result.success();
    }

    private List<OrderInfo> getOrdersByUserName(String userName){
        User user = userService.getUser(userName);
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        return orderInfoMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Indent> getIndents(String userName) {
        List<Indent> indents = new ArrayList<>();
        List<OrderInfo> orderInfos = getOrdersByUserName(userName);
        for (OrderInfo orderInfo : orderInfos) {
            Indent indent = new Indent();
            indent.setOrderInfo(orderInfo);
            Room room = roomService.getRoom(orderInfo.getRoomId());
            indent.setPicture(room.getPicture());
            indents.add(indent);
        }
        return indents;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result updateIndent(OrderInfo orderInfo) {
        Room room = roomService.getRoom(orderInfo.getRoomId());
        room.setStatus(Short.valueOf(orderInfo.getOrderStatus().toString()));
        orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
        roomService.updateRoom(room);
        return Result.success();
    }
}
