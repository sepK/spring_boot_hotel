package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.*;
import com.ecjtu.kongtao.exception.*;
import com.ecjtu.kongtao.service.*;
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
    private CustomerService customerService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private IntakeService intakeService;
    @Resource
    private PhotoService photoService;

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
    public boolean saveOrder(OrderInfo orderInfo) {
        try {
            Room room = new Room();
            room.setId(orderInfo.getRoomid());
            room.setStatus(Short.valueOf(orderInfo.getOstatus().toString()));
            if(!roomService.saveRoom(room)){
                throw new RoomNotFoundException("找不到房间");
            }else{
                int result = orderInfoMapper.updateByPrimaryKey(orderInfo);
                if(result <= 0){
                    throw new RepeatOrderException();
                }else{
                    return true;
                }
            }
        }catch (RoomNotFoundException r){
            throw r;
        }catch (RepeatOrderException roe){
            throw roe;
        }catch (Exception e){
            throw new OrderException("保存数据异常"+e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addOrder(OrderInfo orderInfo) {
        try {
            Room room = roomService.getRoom(orderInfo.getRoomid());
            if(room == null || room.getStatus() != 0){
                throw new RoomNotFoundException("房间找不到或者房间不是空闲状态");
            }else{
                if(customerService.checkName(orderInfo.getCusname())){
                    throw new CustomerNotFoundException("用户不存在");
                }else{
                    if(orderInfo.getEmpId() != null&&employeeService.getEmp(orderInfo.getEmpId()) == null){
                        throw new EmployeeNotFoundException("员工不存在");
                    }else{
                        room.setStatus(Short.valueOf(orderInfo.getOstatus().toString()));
                        roomService.saveRoom(room);
                        return orderInfoMapper.insertSelective(orderInfo) > 0;
                    }
                }
            }
        }catch (RoomNotFoundException rnfe){
            throw rnfe;
        }catch (CustomerNotFoundException cnfe){
            throw cnfe;
        }catch (EmployeeNotFoundException enfe){
            throw enfe;
        }catch (Exception e){
            throw new OrderException("插入数据异常"+e.getMessage());
        }
    }

    @Override
    public List<OrderInfo> getOrdersByRoomId(Integer roomid) {
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andRoomidEqualTo(roomid);
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
        Intake intake = indent.getIntake();
        orderInfo.setOstatus(Integer.valueOf("1"));
        orderInfo.setRoomid(roomId);
        intake.setCusname(orderInfo.getCusname());
        intake.setRoomid(roomId);
        try{
            if(!addOrder(orderInfo)){
                throw new ExtraException("预定失败");
            }else{
               return intakeService.addIntake(intake);
            }
        }catch (RoomNotFoundException rnfe){
            msg += rnfe.getMessage();
        }catch (CustomerNotFoundException cnfe){
            msg += cnfe.getMessage();
        }catch (EmployeeNotFoundException enfe){
            msg += enfe.getMessage();
        }catch (ExtraException e){
            msg += e.getMessage();
        }
        return Result.fail(msg);
    }
    public List<OrderInfo> getOrdersByCusname(String cusname){
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andCusnameEqualTo(cusname);
        return orderInfoMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Indent> getIndents(String cusname) {
        List<Indent> indents = new ArrayList<Indent>();
        List<OrderInfo> orderInfos = getOrdersByCusname(cusname);
        for (OrderInfo orderInfo:orderInfos) {
            Indent indent = new Indent();
            indent.setOrderInfo(orderInfo);
            indent.setPicture(photoService.searchPhotos(orderInfo.getRoomid()).get(0).getPicture());
            indent.setIntake(intakeService.getIntakeByCusNameAndRoomId(orderInfo.getRoomid(),orderInfo.getCusname()));
            indents.add(indent);
        }
        return indents;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result updateIndent(OrderInfo orderInfo) {
        try{
            OrderInfo order = getOrder(orderInfo.getId());
            Room room = roomService.getRoom(order.getRoomid());
            if(orderInfoMapper.updateByPrimaryKeySelective(orderInfo) == 0){
                throw new OrderException("订单更新失败");
            }else{
                room.setStatus(Short.valueOf(orderInfo.getOstatus().toString()));
                if(!roomService.saveRoom(room)){
                    throw new RoomHasOrderException("房间更新失败");
                }else {
                    return Result.success();
                }
            }
        }catch (OrderException e){
            return Result.fail(e.getMessage());
        }catch (RoomHasOrderException e){
            return Result.fail(e.getMessage());
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }

    }
}
