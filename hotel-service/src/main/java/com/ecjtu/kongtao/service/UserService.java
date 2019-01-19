package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface UserService {

	/**
	 * 获取所有用户
	 * @return 用户列表
	 */
	List<User> getUsers();

	/**
	 * 通过id获取用户
	 * @param userId 主键
	 * @return 用户个人信息
	 */
	User getUser(Integer userId);

	/**
	 * 通过id删除用户信息
	 * @param userId 用户id
	 */
	void delUser(Integer userId);

	/**
	 * 更新用户信息
	 * @param user bean
	 */
	void updateUser(User user);

	/**
	 * 通过用户名搜索用户 模糊查询
	 * @param userName 用户名
	 * @return 用户集合
	 */
	List<User> searchUser(String userName);

	/**
	 * 添加用户
	 * @param user 用户信息
	 */
	void addUser(User user);

	/**
	 * 检查用户是否存在
	 * @param userId 用户id
	 * @return true or false
	 */
	boolean checkUserById(Integer userId);

	/**
	 * 检查用户登录名 密码是否正确
	 * @param user 用户信息
	 * @return true or false
	 */
    boolean login(User user);

	/**
	 * 检查用户名是否被占用
	 * @param name 名称
	 * @return true or false
	 */
	boolean checkName(String name);
}
