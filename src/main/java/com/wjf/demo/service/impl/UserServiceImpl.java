package com.wjf.demo.service.impl;

import com.wjf.demo.dao.UserMapper;
import com.wjf.demo.entity.User;
import com.wjf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public List<User> findUserByUserId(User user) {
        return userMapper.findUserByUserId(user);
    }

    @Override
    public List<User> findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }
}
