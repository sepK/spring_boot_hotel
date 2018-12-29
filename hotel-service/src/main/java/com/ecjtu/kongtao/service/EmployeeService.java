package com.ecjtu.kongtao.service;

import com.ecjtu.kongtao.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface EmployeeService {

    List<Employee> getEmps();

    Employee getEmp(Integer id);

    boolean saveEmp(Employee employee);

    boolean addEmp(Employee employee);

    boolean delEmp(Integer id);

    boolean checkEmpName(String empName);

    List<Employee> getEmpsByName(String empName);
}
