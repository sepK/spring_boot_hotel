package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.User;
import com.ecjtu.kongtao.bean.UserExample;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author sepK
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

	@Override
	public List<User> getUsers() {
		return userMapper.selectByExample(null);
	}

	@Override
	public User getUser(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public void delUser(Integer userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<User> searchUser(String userName) {
		UserExample customerExample = new UserExample();
		UserExample.Criteria criteria = customerExample.createCriteria();
		criteria.andUserNameLike("%" + userName + "%");
		return userMapper.selectByExample(customerExample);
	}

	@Override
	public void addUser(User user) {
		userMapper.insert(user);
	}

	@Override
	public boolean checkUserById(Integer userId) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
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

	/**
	 * 检查用户名是否被占用
	 * @param name 名称
	 * @return true or false
	 */
	@Override
	public boolean checkName(String name) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(name);
		return userMapper.selectByExample(example).size() == 0;
	}

}
