package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.housing.Housing;
import com.ecjtu.kongtao.bean.housing.Indent;
import com.ecjtu.kongtao.bean.order.OrderInfo;
import com.ecjtu.kongtao.bean.order.OrderInfoExample;
import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.exception.UserException;
import com.ecjtu.kongtao.service.*;
import com.ecjtu.kongtao.utils.ErrorCode;
import com.ecjtu.kongtao.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        return orderInfoMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public OrderInfo getOrder(Integer id) {
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(OrderInfo orderInfo) {
        Room room = new Room();
        room.setRoomId(orderInfo.getRoomId());
        room.setStatus(Short.valueOf(orderInfo.getOrderStatus().toString()));
        roomService.updateRoom(room);
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
            } else if (userService.checkName(String.valueOf(orderInfo.getUserId()))) {
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
    @Transactional(rollbackFor = Exception.class)
    public Result addIndent(Integer roomId, Indent indent) {
        String msg = "";
        OrderInfo orderInfo = indent.getOrderInfo();
        Housing housing = indent.getHousing();
        orderInfo.setOrderStatus(Integer.valueOf("1"));
        orderInfo.setRoomId(roomId);
        //orderInfo.getUserId()
        housing.setUserId(1);
        housing.setRoomId(roomId);
        addOrder(orderInfo);
        return Result.success();
    }

    private List<OrderInfo> getOrdersByUserName(String userName){
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();

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
            indents.add(indent);
        }
        return indents;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result updateIndent(OrderInfo orderInfo) {
        /*OrderInfo order = getOrder(orderInfo.getOrderId());
        Room room = roomService.getRoom(order.getRoomId());
        if(orderInfoMapper.updateByPrimaryKeySelective(orderInfo) == 0){
            throw new OrderException("订单更新失败");
        }else{
            room.setStatus(Short.valueOf(orderInfo.getOrderStatus().toString()));
            if(!roomService.saveRoom(room)){
                throw new RoomHasOrderException("房间更新失败");
            }else {
                return Result.success();
            }
        }*/
        return null;
    }
}
