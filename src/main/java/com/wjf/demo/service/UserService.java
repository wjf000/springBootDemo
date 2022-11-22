package com.wjf.demo.service;

import com.wjf.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    List<User> findAllUsers();


    List<User> findUserByUserId(User user);

    List<User> findUserByUserName(String userName);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);
}
