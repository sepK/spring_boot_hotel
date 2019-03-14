package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.user.User;
import com.ecjtu.kongtao.utils.ConfigKey;
import com.ecjtu.kongtao.utils.ErrorCode;
import com.ecjtu.kongtao.utils.GraphicHelper;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author sepK
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@RequestMapping("/index")
	public String toIndex() {
		return "index";
	}
	
	@RequestMapping(value="/users",method= RequestMethod.GET)
	@ResponseBody
	public Result getUsers(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, ConfigKey.DEFAULT_PAGE_SIZE);
		List<User> list = userService.getUsers();
		PageInfo<User> pageInfo = new PageInfo<>(list, ConfigKey.NAVIGATE_PAGE);
		return Result.success().add("pageInfo", pageInfo);
	}
	
	@RequestMapping(value="/user/{userId}",method= RequestMethod.GET)
	@ResponseBody
	public Result getUser(@PathVariable("userId") Integer userId) {
		User user = userService.getUser(userId);
		return Result.success().add("user", user);
	}

	@RequestMapping(value="/user/{userId}", method= RequestMethod.DELETE)
	@ResponseBody
	public Result delUser(@PathVariable("userId") Integer userId) {
		userService.delUser(userId);
		return Result.success();
	}

	@RequestMapping(value="/user/{userId}", method= RequestMethod.POST)
	@ResponseBody
	public Result updateUser(@PathVariable("userId") Integer userId, User user) {
		userService.updateUser(user);
		return Result.success();
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseBody
	public Result addUser(User user) {
		userService.addUser(user);
		return Result.success();
	}

	@RequestMapping("/searchUser")
	@ResponseBody
	public Result searchUser(@RequestParam("userName") String userName) {
		List<User> list = userService.searchUser(userName);
		return Result.success().add("list", list);
	}

	@RequestMapping("/checkName")
	@ResponseBody
	public Result checkName(@RequestParam("userName") String userName) {
		if(userService.checkName(userName)) {
			return Result.success();
		}else {
			return Result.fail();
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(User user){
        if(userService.login(user)){
            return Result.success().add("user",user);
        }else{
            return Result.fail(ErrorCode.ERROR_PARAM_LOGIN);
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(){
		return "redirect:/app/main.html";
	}
	
	@RequestMapping("/checkVerifyCode")
	@ResponseBody
	public Result checkVerifyCode(String verifyCode, HttpSession session) {
		if (session.getAttribute("/user/verifyCode").equals(verifyCode)) {
			return Result.success();
		} else {
			return Result.fail();
		}
	}

	@RequestMapping("/verifyCode")
	public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		String uri = request.getRequestURI();
		System.out.println(uri);
		final int width = 180; 
		final int height = 40; 
		final String imgType = "jpeg"; 
		final OutputStream output = response.getOutputStream();
		String code = GraphicHelper.create(width, height, imgType, output);

		session.setAttribute(uri, code);

		System.out.println(session.getAttribute(uri));

	}
}

