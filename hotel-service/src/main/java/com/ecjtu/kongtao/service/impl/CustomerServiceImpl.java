package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.Customer;
import com.ecjtu.kongtao.bean.CustomerExample;
import com.ecjtu.kongtao.bean.CustomerExample.Criteria;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public class CustomerServiceImpl extends BaseService implements CustomerService {

	@Override
	public List<Customer> getCustomers() {
		return customerMapper.selectByExample(null);
	}

	@Override
	public Customer getCustomer(Integer id) {
		return customerMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean delCustomer(Integer id) {
		return customerMapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return customerMapper.updateByPrimaryKeySelective(customer) > 0;
	}

	@Override
	public List<Customer> searchCus(String cusName) {
		CustomerExample customerExample = new CustomerExample();
		Criteria criteria = customerExample.createCriteria();
		criteria.andCustomerNameLike("%" + cusName + "%");
		return customerMapper.selectByExample(customerExample);
	}

	@Override
	public Boolean addCustomer(Customer customer) {
		return customerMapper.insert(customer) > 0;
	}

	@Override
	public boolean checkName(String name) {
		CustomerExample example = new CustomerExample();
		Criteria criteria = example.createCriteria();
		criteria.andCustomerNameEqualTo(name);
		return customerMapper.selectByExample(example).size() == 0;
	}

	@Override
	public boolean login(Customer customer) {
		CustomerExample example = new CustomerExample();
        Criteria criteria = example.createCriteria();
        criteria.andCustomerNameEqualTo(customer.getCustomerName());
        criteria.andPasswordEqualTo(customer.getPassword());
        return customerMapper.selectByExample(example) != null;
	}

}
