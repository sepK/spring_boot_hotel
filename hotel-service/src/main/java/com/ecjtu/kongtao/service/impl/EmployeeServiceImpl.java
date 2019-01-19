package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.Employee;
import com.ecjtu.kongtao.bean.EmployeeExample;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public class EmployeeServiceImpl extends BaseService implements EmployeeService {

    @Override
    public List<Employee> getEmps() {
        return employeeMapper.selectByExample(null);
    }

    @Override
    public Employee getEmp(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveEmp(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void addEmp(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void delEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean checkEmpName(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        return employeeMapper.selectByExample(example).size() == 0;
    }

    @Override
    public List<Employee> getEmpsByName(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameLike(empName);
        return employeeMapper.selectByExample(example);
    }
}
