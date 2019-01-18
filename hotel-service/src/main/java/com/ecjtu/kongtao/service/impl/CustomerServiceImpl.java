package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.User;
import com.ecjtu.kongtao.bean.UserExample;
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
	public List<User> getCustomers() {
		return userMapper.selectByExample(null);
	}

	@Override
	public User getCustomer(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean delCustomer(Integer id) {
		return userMapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public boolean updateCustomer(User customer) {
		return userMapper.updateByPrimaryKeySelective(customer) > 0;
	}

	@Override
	public List<User> searchCus(String cusName) {
		UserExample customerExample = new UserExample();
		UserExample.Criteria criteria = customerExample.createCriteria();
		criteria.andUserNameLike("%" + cusName + "%");
		return userMapper.selectByExample(customerExample);
	}

	@Override
	public Boolean addCustomer(User user) {
		return userMapper.insert(user) > 0;
	}

	@Override
	public boolean checkName(String name) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(name);
		return userMapper.selectByExample(example).size() == 0;
	}

	@Override
	public boolean login(User user) {
		UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andPasswordEqualTo(user.getPassword());
        return userMapper.selectByExample(example) != null;
	}

}
