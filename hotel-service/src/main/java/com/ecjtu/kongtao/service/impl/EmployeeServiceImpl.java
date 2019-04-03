package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.employee.Employee;
import com.ecjtu.kongtao.bean.employee.EmployeeExample;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.EmployeeService;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
@CacheConfig(cacheNames = "employee")
public class EmployeeServiceImpl extends BaseService implements EmployeeService {

    @Override
    @Cacheable(key = "'all'")
    public List<Employee> getEmps() {
        return employeeMapper.selectByExample(null);
    }

    @Override
    @Cacheable(key = "#employeeId")
    public Employee getEmp(Integer employeeId) {
        return employeeMapper.selectByPrimaryKey(employeeId);
    }

    @Override
    @Caching(put = @CachePut(key = "#employee.empId"), evict = @CacheEvict(key = "'all'"))
    public void saveEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Override
    @Caching(evict = @CacheEvict(key = "'all'"))
    public void addEmp(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    @Caching(evict = {@CacheEvict(key = "#employeeId"), @CacheEvict(key = "'all")})
    public void delEmp(Integer employeeId) {
        employeeMapper.deleteByPrimaryKey(employeeId);
    }

    @Override
    @Cacheable(key = "'check' + #empName")
    public boolean checkEmpName(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        return employeeMapper.selectByExample(example).size() == 0;
    }

    @Override
    @Cacheable(key = "'all' + #empName")
    public List<Employee> getEmpsByName(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameLike(empName);
        return employeeMapper.selectByExample(example);
    }
}
