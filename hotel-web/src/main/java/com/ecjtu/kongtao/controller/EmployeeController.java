package com.ecjtu.kongtao.controller;

import com.ecjtu.kongtao.bean.employee.Employee;
import com.ecjtu.kongtao.config.ConfigKey;
import com.ecjtu.kongtao.manager.SessionManager;
import com.ecjtu.kongtao.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sepK
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

    @RequestMapping("/index03")
    public  String toIndex(){
        return "index03";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public Result getEmployee(@RequestParam("pn") Integer pn, HttpServletRequest request) {
        SessionManager.setSession(request);
        PageHelper.startPage(pn, ConfigKey.DEFAULT_PAGE_SIZE);
        List<Employee> list = employeeService.getEmps();
        PageInfo<Employee> pageInfo = new PageInfo<>(list, ConfigKey.NAVIGATE_PAGE);
        return  Result.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getEmp(@PathVariable("empId") Integer empId) {
        Employee employee = employeeService.getEmp(empId);
        return  Result.success().add("emp",employee);
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.PUT)
    @ResponseBody
    public Result saveEmp(Employee employee) {
        employeeService.saveEmp(employee);
        return  Result.success();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    @ResponseBody
    public Result addEmp(Employee employee) {
        employeeService.addEmp(employee);
        return  Result.success();
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delEmp(@PathVariable("empId") Integer empId) {
        employeeService.delEmp(empId);
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
    public Result searchEmps(@RequestParam("empName") String empName) {
        List<Employee> list = employeeService.getEmpsByName(empName);
        return  Result.success().add("list",list);
    }
}
