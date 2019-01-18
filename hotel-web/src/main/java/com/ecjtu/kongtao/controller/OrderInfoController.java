package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.Indent;
import com.ecjtu.kongtao.bean.OrderInfo;
import com.ecjtu.kongtao.exception.CustomerNotFoundException;
import com.ecjtu.kongtao.exception.EmployeeNotFoundException;
import com.ecjtu.kongtao.exception.RepeatOrderException;
import com.ecjtu.kongtao.exception.RoomNotFoundException;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sepK
 */
@Controller
@RequestMapping("/order")
public class OrderInfoController extends BaseController{

    @RequestMapping("/index04")
    public String toIndex(){
        return "/admin/index04";
    }

    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    @ResponseBody
    public Result getOrders(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn,10);
        List<OrderInfo> list = orderInfoService.getOrders();
        PageInfo<OrderInfo> pageInfo = new PageInfo<>(list,5);
        return Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/order/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result getOrder(@PathVariable("id") Integer id){
        OrderInfo orderInfo = orderInfoService.getOrder(id);
        return Result.success().add("orderInfo", orderInfo);
    }
    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result saveOrder(OrderInfo orderInfo){
        String msg = null;
        try {
            if(orderInfoService.saveOrder(orderInfo)){
                return Result.success();
            }
        }catch (RoomNotFoundException | RepeatOrderException r){
            msg = r.getMessage();
        }
        return Result.fail(msg);
    }
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public Result addOrder(OrderInfo orderInfo){
        String msg = null;
        try{
            if(orderInfoService.addOrder(orderInfo)){
                return Result.success();
            }
        }catch (RoomNotFoundException | CustomerNotFoundException | EmployeeNotFoundException rnfe){
            msg = rnfe.getMessage();
        }
        return Result.fail(msg);
    }
    @RequestMapping(value = "/searchOrders",method = RequestMethod.GET)
    @ResponseBody
    public Result searchOrders(@RequestParam("roomid") Integer roomid){
        List<OrderInfo> list = orderInfoService.getOrdersByRoomId(roomid);
        return Result.success().add("list",list);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delOrder(@PathVariable("id") Integer id){
        if(orderInfoService.delOrder(id)){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @RequestMapping(value = "/addIndent/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Result addIndent(@PathVariable("id") Integer roomId, Indent indent){
        return orderInfoService.addIndent(roomId, indent);
    }

    @RequestMapping(value = "/getIndents",method = RequestMethod.GET)
    @ResponseBody
    public Result getIndents(@RequestParam("cusname") String cusname){
        List<Indent> indents = orderInfoService.getIndents(cusname);
        return Result.success().add("indents",indents);
    }

    @RequestMapping(value = "/updateIndent",method = RequestMethod.POST)
    @ResponseBody
    public Result updateIndent(OrderInfo orderInfo){

        return orderInfoService.updateIndent(orderInfo);
    }
}
