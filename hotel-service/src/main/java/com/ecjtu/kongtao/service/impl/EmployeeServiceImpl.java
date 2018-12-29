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
    public boolean saveEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee) > 0;
    }

    @Override
    public boolean addEmp(Employee employee) {
        return employeeMapper.insert(employee) > 0;
    }

    @Override
    public boolean delEmp(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean checkEmpName(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        return employeeMapper.selectByExample(example).size() == 0;
    }


    public List<Employee> getEmpsByName(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameLike(empName);
        return employeeMapper.selectByExample(example);
    }
}
