package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.room.Room;
import com.ecjtu.kongtao.manager.SessionManager;
import com.ecjtu.kongtao.utils.ConfigKey;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author t.k
 * @date 2019/2/28 18:48
 */
@Controller
@RequestMapping(value = "/app")
public class FrontDeskController extends BaseController{

    @RequestMapping(value="/rooms",method = RequestMethod.GET)
    @ResponseBody
    public Result getRooms(@RequestParam() Integer pn, HttpServletRequest request) {
        PageHelper.startPage(pn, ConfigKey.DEFAULT_PAGE_SIZE);
        List<Room> list = roomService.getRooms();
        PageInfo<Room> pageInfo = new PageInfo<>(list, ConfigKey.NAVIGATE_PAGE);
        return Result.success().add("pageInfo", pageInfo);
    }
}
