package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.Room;
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
@RequestMapping("/room")
public class RoomController extends BaseController{

    @RequestMapping("/index02")
    public String toIndex(){
        return "/admin/index02";
    }
    @RequestMapping(value="/rooms",method = RequestMethod.GET)
    @ResponseBody
    public Result getRooms(@RequestParam() Integer pn){
        PageHelper.startPage(pn,10);
        List<Room> list = roomService.getRooms();
        PageInfo<Room> pageInfo = new PageInfo<>(list,5);
        return Result.success().add("pageInfo",pageInfo);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getRoom(@PathVariable("id") Integer id){
        Room room = roomService.getRoom(id);
        return Result.success().add("room",room);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result saveRoom(@PathVariable("id") Integer id, Room room){
        if(roomService.saveRoom(room)){
            return Result.success();
        }else {
            return  Result.fail();
        }

    }

    @RequestMapping(value = "/room/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delRoom(@PathVariable("id") Integer id){
        if(roomService.delRoom(id)){
            return Result.success();
        }else{
            return Result.fail();
        }
    }
    @RequestMapping(value = "/searchRoom",method = RequestMethod.POST)
    @ResponseBody
    public Result searchRoom(@RequestParam("roomNumber") String roomNumber){
        List<Room> list = roomService.searchRoomByRoomNumber(roomNumber);
        return Result.success().add("list",list);
    }


    @RequestMapping(value = "/room", method = RequestMethod.POST)
    @ResponseBody
    public Result addRoom(Room room){
        if(roomService.addRoom(room)) {
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @RequestMapping(value = "/checkRoomNumber", method = RequestMethod.POST)
    @ResponseBody
    public Result checkRoomNumber(@RequestParam("roomNumber") String number){
        if(roomService.checkRoomNumber(number)){
            return Result.success();
        }else {
            return Result.fail();
        }
    }

    @RequestMapping(value = "/emptyRooms",method = RequestMethod.GET)
    @ResponseBody
    public Result emptyRooms(){
        //todo
        List<Room> rooms = null;
        return Result.success().add("rooms",rooms);
    }


    @RequestMapping("/searchByStatus")
    @ResponseBody
    public Result searchByStatus(@RequestParam("status") short status){
        List<Room> list = roomService.getRoomByStatus(status);
        return Result.success().add("list",list);
    }

}
