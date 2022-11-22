package com.wjf.demo.dao;

import com.wjf.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 查找所有用户信息
     *
     * @return
     */
    List<User> findAllUser();

    List<User> findAllUsers();

    /**
     * 根据id查找某个用户的信息
     *
     * @param user
     * @return
     */
    List<User> findUserByUserId(User user);

    /**
     * 根据名称查找某个用户的信息
     *
     * @param username
     * @return 当有参数时最好用@Param("xxx")形式命名参数名，xxxmapper.xml文件以命名后的参数名来接受参数，
     * 否则xxxmapper.xml按顺序接受参数且参数名可随意指定不规范
     */
    List<User> findUserByUserName(@Param("username") String username);

    /**
     * 插入一条用户的信息
     *
     * @return
     */
    int insertUser(User user);

    /**
     * 更新某个用户的信息
     *
     * @return
     */
    int updateUser(User user);

    /**
     * 删除某个用户的信息
     *
     * @return
     */
    int deleteUser(User user);
}

