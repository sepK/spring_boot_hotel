package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.housing.Housing;
import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.bean.user.User;
import com.ecjtu.kongtao.config.ConfigKey;
import com.ecjtu.kongtao.exception.UserException;
import com.ecjtu.kongtao.utils.ErrorCode;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author sepK
 */
@Controller
@RequestMapping("/housing")
public class HousingController extends BaseController{

    @RequestMapping("/index06")
    public String toIndex(){
        return "index06";
    }

    @RequestMapping(value = "/housings", method = RequestMethod.GET)
    @ResponseBody
    public Result getHousings(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn, ConfigKey.DEFAULT_PAGE_SIZE);
        List<Housing> list = housingService.getHousings();
        PageInfo<Housing> pageInfo = new PageInfo<>(list, ConfigKey.NAVIGATE_PAGE);
        return Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/housing/{housingId}",method = RequestMethod.GET)
    @ResponseBody
    public Result getHousing(@PathVariable("housingId") Integer housingId){
        Housing housing = housingService.getHousing(housingId);
        return Result.success().add("Housing", housing);
    }

    @RequestMapping(value = "/housing/{housingId}", method = RequestMethod.PUT)
    @ResponseBody
    public Result saveHousing(@PathVariable("housingId") Integer housingId, Housing housing){
        housingService.saveHousing(housing);
        return Result.success();
    }

    @RequestMapping(value = "/housing", method = RequestMethod.POST)
    @ResponseBody
    public Result addHousing(@RequestParam("roomNumber") String roomNumber, @RequestParam("userName") String userName, Housing housing) {
        User user = userService.searchUser(userName).get(0);
        Room room = roomService.searchRoomByRoomNumber(roomNumber).get(0);
        if(room == null) {
            throw new UserException(ErrorCode.ERROR_ROOM_NOT_EXIST);
        } else {
            if (userService.checkName(userName)) {
                throw new UserException(ErrorCode.ERROR_USER_NOT_EXIST);
            } else {
                if (housing.getEndTime().before(housing.getStartTime())) {
                    throw new UserException(ErrorCode.ERROR_TIME_RANGE_ERROR);
                } else {
                    Date now = new Date();
                    housing.setCreateTime(now);
                    housing.setLastModifyTime(now);
                    housingService.addHousing(housing);
                }
            }
        }
        return Result.success();
    }

    @RequestMapping(value = "/housing/{housingId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delHousing(@PathVariable("housingId") Integer housingId){
        housingService.delHousing(housingId);
        return Result.success();
    }

    @RequestMapping(value = "/searchHousings", method = RequestMethod.GET)
    @ResponseBody
    public Result searchHousings(@RequestParam("userName") String userName){
        List<Housing> housings = housingService.searchHousings(userName);
        return Result.success().add("housings", housings);
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
