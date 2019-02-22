package com.ecjtu.kongtao.service;

import com.ecjtu.kongtao.bean.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface EmployeeService {

    /**
     * 获取所有员工信息
     * @return 员工列表
     */
    List<Employee> getEmps();

    /**
     * 通过员工id 查询员工信息
     * @param id 员工id
     * @return 员工信息
     */
    Employee getEmp(Integer id);

    /**
     * 保存员工信息
     * @param employee 员工信息
     */
    void saveEmp(Employee employee);

    /**
     * 添加员工信息
     * @param employee 员工信息
     * @return
     */
    void addEmp(Employee employee);

    /**
     * 删除员工信息
     * @param id
     */
    void delEmp(Integer id);


    boolean checkEmpName(String empName);

    List<Employee> getEmpsByName(String empName);
}
