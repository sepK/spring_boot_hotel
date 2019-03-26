package com.ecjtu.kongtao.service.impl;

import com.ecjtu.kongtao.bean.user.User;
import com.ecjtu.kongtao.bean.user.UserExample;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author sepK
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Override
    @Cacheable(value = "user", key = "'all'")
    public List<User> getUsers() {
        return userMapper.selectByExample(null);
    }

    @Override
    @Cacheable(value = "user", key = "#userId")
    public User getUser(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Caching(evict = {@CacheEvict(value = "user", key = "#userId"), @CacheEvict(value = "user", key = "'all'")})
    public void delUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Caching(put = @CachePut(value = "user", key = "#user.userId"), evict = @CacheEvict(value = "user", key = "'all'"))
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Cacheable(value = "user", key = "'search' + #userName")
    public List<User> searchUser(String userName) {
        UserExample customerExample = new UserExample();
        UserExample.Criteria criteria = customerExample.createCriteria();
        criteria.andUserNameLike("%" + userName + "%");
        return userMapper.selectByExample(customerExample);
    }

    @Override
    @Cacheable(value = "user", key = "'get' + #userName")
    public User getUser(String userName) {
        UserExample customerExample = new UserExample();
        UserExample.Criteria criteria = customerExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(customerExample);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    @Caching(put = @CachePut(value = "user", key = "#user.userId"), evict = @CacheEvict(value = "user", key = "'all'"))
    public void addUser(User user) {
        Date now = new Date();
        user.setCreateTime(now);
        user.setLastModifyTime(now);
        userMapper.insert(user);
    }

    @Override
    @Cacheable(value = "user", key = "'check' + #userId")
    public boolean checkUserById(Integer userId) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return userMapper.selectByExample(example).size() == 0;
    }

    @Override
    @Cacheable(value = "user", key = "'login' + #user.userId")
    public boolean login(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andPasswordEqualTo(user.getPassword());
        return userMapper.selectByExample(example) != null;
    }

    /**
     * 检查用户名是否被占用
     *
     * @param userName 名称
     * @return true or false
     */
    @Override
    @Cacheable(value = "user", key = "'check' + #userName")
    public boolean checkName(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        return userMapper.selectByExample(example).size() == 0;
    }

}
