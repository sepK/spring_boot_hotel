package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.room.RoomStatus;
import com.ecjtu.kongtao.manager.SessionManager;
import com.ecjtu.kongtao.utils.ConfigKey;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author sepK
 */
@Controller
@RequestMapping("/room")
public class RoomController extends BaseController{

    @RequestMapping("/index02")
    public String toIndex(){
        return "index02";
    }

    @RequestMapping(value="/rooms",method = RequestMethod.GET)
    @ResponseBody
    public Result getRooms(@RequestParam() Integer pn, HttpServletRequest request) {
        SessionManager.setSession(request);
        PageHelper.startPage(pn, ConfigKey.DEFAULT_PAGE_SIZE);
        List<Room> list = roomService.getRooms();
        PageInfo<Room> pageInfo = new PageInfo<>(list, ConfigKey.NAVIGATE_PAGE);
        return Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/room/{roomId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getRoom(@PathVariable("roomId") Integer roomId){
        Room room = roomService.getRoom(roomId);
        return Result.success().add("room", room);
    }

    @RequestMapping(value = "/room/{roomId}", method = RequestMethod.POST)
    @ResponseBody
    public Result saveRoom(@PathVariable("roomId") Integer roomId, Room room, MultipartFile file) {
        upLoadPhoto(file, room);
        roomService.updateRoom(room);
        return Result.success();
    }

    @RequestMapping(value = "/room/{roomId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delRoom(@PathVariable("roomId") Integer roomId){
        roomService.delRoom(roomId);
        return Result.success();

    }
    @RequestMapping(value = "/searchRoom", method = RequestMethod.POST)
    @ResponseBody
    public Result searchRoom(@RequestParam("roomNumber") String roomNumber){
        List<Room> list = roomService.searchRoomByRoomNumber(roomNumber);
        return Result.success().add("list", list);
    }


    @RequestMapping(value = "/room", method = RequestMethod.POST)
    @ResponseBody
    public Result addRoom(Room room, MultipartFile file) {
        upLoadPhoto(file, room);
        roomService.addRoom(room);
        return Result.success();
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

    @RequestMapping(value = "/emptyRooms", method = RequestMethod.GET)
    @ResponseBody
    public Result emptyRooms(){
        List<Room> rooms = roomService.getRoomByStatus((short) RoomStatus.IDLE.getStatus());
        return Result.success().add("rooms", rooms);
    }


    @RequestMapping("/searchByStatus")
    @ResponseBody
    public Result searchByStatus(@RequestParam("status") short status){
        List<Room> list = roomService.getRoomByStatus(status);
        return Result.success().add("list", list);
    }

    private void upLoadPhoto(MultipartFile file, Room room){
        if(!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String path = "F:\\Idea Project\\spring-boot\\hotel-web\\src\\main\\resources\\static\\images\\";

            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            File newFile = new File(path + newFileName);
            room.setPicture("/images/" + newFileName);
            try {
                file.transferTo(newFile);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
