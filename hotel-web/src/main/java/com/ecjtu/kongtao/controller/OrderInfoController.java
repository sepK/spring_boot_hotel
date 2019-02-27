package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.housing.Indent;
import com.ecjtu.kongtao.bean.order.OrderInfo;
import com.ecjtu.kongtao.utils.ConfigKey;
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
        return "index04";
    }

    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    @ResponseBody
    public Result getOrders(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn, ConfigKey.DEFAULT_PAGE_SIZE);
        List<OrderInfo> list = orderInfoService.getOrders();
        PageInfo<OrderInfo> pageInfo = new PageInfo<>(list, ConfigKey.NAVIGATE_PAGE);
        return Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/order/{orderId}",method = RequestMethod.GET)
    @ResponseBody
    public Result getOrder(@PathVariable("orderId") Integer orderId){
        OrderInfo orderInfo = orderInfoService.getOrder(orderId);
        return Result.success().add("orderInfo", orderInfo);
    }
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateOrder(@PathVariable("orderId") Integer orderId, OrderInfo orderInfo){
        orderInfoService.updateOrder(orderInfo);
        return Result.success();

    }
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public Result addOrder(OrderInfo orderInfo){
        orderInfoService.addOrder(orderInfo);
        return Result.success();

    }
    @RequestMapping(value = "/searchOrders", method = RequestMethod.GET)
    @ResponseBody
    public Result searchOrders(@RequestParam("roomId") Integer roomId){
        List<OrderInfo> list = orderInfoService.getOrdersByRoomId(roomId);
        return Result.success().add("list",list);
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delOrder(@PathVariable("orderId") Integer orderId){
        if(orderInfoService.delOrder(orderId)){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @RequestMapping(value = "/addIndent/{roomId}",method = RequestMethod.POST)
    @ResponseBody
    public Result addIndent(@PathVariable("roomId") Integer roomId, Indent indent){
        return orderInfoService.addIndent(roomId, indent);
    }

    @RequestMapping(value = "/getIndents",method = RequestMethod.GET)
    @ResponseBody
    public Result getIndents(@RequestParam("userName") String userName){
        List<Indent> indents = orderInfoService.getIndents(userName);
        return Result.success().add("indents", indents);
    }

    @RequestMapping(value = "/updateIndent",method = RequestMethod.POST)
    @ResponseBody
    public Result updateIndent(OrderInfo orderInfo){
        return orderInfoService.updateIndent(orderInfo);
    }
}
