package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.User;
import com.ecjtu.kongtao.utils.GraphicHelper;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/customer")
public class CustomerController extends BaseController{
	
	@RequestMapping("/index")
	public String toIndex() {
		return "index";
	}
	
	@RequestMapping(value="/customers",method= RequestMethod.GET)
	@ResponseBody
	public Result getCustomers(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 10);
		List<User> list = customerService.getCustomers();
		PageInfo<User> pageInfo = new PageInfo<>(list,5);
		return Result.success().add("pageInfo", pageInfo);
	}
	
	@RequestMapping(value="/customer/{id}",method= RequestMethod.GET)
	@ResponseBody
	public Result getCustomer(@PathVariable("id") Integer id) {
		User customer = customerService.getCustomer(id);
		return Result.success().add("customer", customer);
	}
	@RequestMapping(value="/customer/{id}",method= RequestMethod.DELETE)
	@ResponseBody
	public Result delCustomer(@PathVariable("id") Integer id) {
		Boolean b = customerService.delCustomer(id);
		return Result.success();
	}
	@RequestMapping(value="/customer/{id}", method= RequestMethod.POST)
	@ResponseBody
	public Result updateCustomer(@PathVariable("id") Integer id, User user) {
		boolean b = customerService.updateCustomer(user);
		return Result.success();
	}
	@RequestMapping("/customer")
	@ResponseBody
	public Result addCustomer(User user) {
		Boolean boolean1 = customerService.addCustomer(user);
		return Result.success();
	}
	@RequestMapping("/searchCus")
	@ResponseBody
	public Result searchCus(@RequestParam("cusName") String cusName) {
		List<User> list = customerService.searchCus(cusName);
		return Result.success().add("list", list);
	}
	@RequestMapping("/checkName")
	@ResponseBody
	public Result checkName(@RequestParam("cusName") String name) {
		if(customerService.checkName(name)) {
			return Result.success();
		}else {
			return Result.fail();
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(User user, Model model){
        if(customerService.login(user)){
            return Result.success("登陆成功").add("user",user);
        }else{
            return Result.fail("用户名或者密码错误");
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(){
		return "redirect:/app/main.html";
	}
	
	@RequestMapping("/checkVerifyCode")
	@ResponseBody
	public Result checkVerifyCode(String verifyCode, HttpSession session) {
		if (session.getAttribute("/customer/verifyCode").equals(verifyCode)) {
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

