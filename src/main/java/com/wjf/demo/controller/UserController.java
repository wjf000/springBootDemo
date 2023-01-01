package com.wjf.demo.controller;

import com.wjf.demo.entity.User;
import com.wjf.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关接口")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
    public List<User> findAll() {
        return userService.findAllUser();
    }

    @GetMapping("/getAllUsers")
    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
    public List<User> findAlls() {
        return userService.findAllUsers();
    }

    @GetMapping("/findUserByUserId")
    @ApiParam(name = "user", value = "用户对象")
    @ApiOperation(value = "根据用户id查找用户", notes = "根据用户id查找用户")
    public List<User> findUserByUserId(User user) {
        return userService.findUserByUserId(user);
    }

    @GetMapping("/findUserByUserName/{username}")
    @ApiImplicitParam(name = "username", value = "用户名称", paramType = "String", required = true)
    @ApiOperation(value = "根据用户名称查找用户", notes = "根据用户名称查找用户")
    public List<User> findUserByUserName(@PathVariable String username) {
        return userService.findUserByUserName(username);
    }

    @PostMapping("/insertUser")
    @ApiOperation(value = "新增一个用户", notes = "新增一条用户信息")
    public int insertUser(User user) {
        return userService.insertUser(user);
    }

    @PutMapping("/updateUser")
    @ApiOperation(value = "更新一个用户", notes = "更新一条用户信息")
    public int updateUser(User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser")
    @ApiOperation(value = "删除一个用户", notes = "删除一条用户信息")
    public int deleteUser(User user) {
        return userService.deleteUser(user);
    }
}
