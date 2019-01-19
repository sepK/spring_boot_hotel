package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.Employee;
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
@RequestMapping("/employee")
public class EmployeeController extends BaseController{

    @RequestMapping("/index03")
    public  String toIndex(){
        return "/admin/index03";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public Result getEmployee(@RequestParam("pn") Integer pn){
        PageHelper.startPage(pn, ConfigKey.DEFAULT_PAGE_SIZE);
        List<Employee> list = employeeService.getEmps();
        PageInfo<Employee> pageInfo = new PageInfo<>(list, ConfigKey.NAVIGATE_PAGE);
        return  Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result getEmp(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmp(id);
        return  Result.success().add("emp",employee);
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Result saveEmp(@PathVariable("id") Integer id, Employee employee){
        employeeService.saveEmp(employee);
        return  Result.success();
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    @ResponseBody
    public Result addEmp(Employee employee){
        employeeService.addEmp(employee);
        return  Result.success();
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delEmp(@PathVariable("id") Integer id){
        employeeService.delEmp(id);
        return  Result.success();
    }

    @RequestMapping(value = "/checkEmpName",method = RequestMethod.GET)
    @ResponseBody
    public Result checkEmpName(@RequestParam("empName") String empName){
        if(employeeService.checkEmpName(empName)){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @RequestMapping(value = "/searchEmps")
    @ResponseBody
    public Result searchEmps(@RequestParam("empName") String empName){
        List<Employee> list = employeeService.getEmpsByName(empName);
        return  Result.success().add("list",list);
    }
}
