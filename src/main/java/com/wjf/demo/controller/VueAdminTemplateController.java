package com.wjf.demo.controller;

import com.wjf.demo.entity.UserInfo;
import com.wjf.demo.entity.VueAdminTemplateUser;
import com.wjf.demo.service.VueAdminTemplateService;
import com.wjf.demo.utils.HttpResponse;
import com.wjf.demo.utils.JWTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dev-api")
@Api(tags = "学生管理相关接口")
public class VueAdminTemplateController {

    @Autowired
    HttpResponse httpResponse;

    @Autowired
    VueAdminTemplateService vueAdminTemplateService;

    @PostMapping("/vue-admin-template/user/login")
    @ApiOperation(value = "登录接口", notes = "登录")
    public HttpResponse getToken(@RequestBody VueAdminTemplateUser user) {
        HashMap<String,String> hashMap = new HashMap<>();
        String username = user.getUsername();
        String password = user.getPassword();
        if (username.equals("admin") && password.equals("111111")) {
            user.setId(99);
            user.setUsername(username);
            user.setPassword(password);
            httpResponse.setCode(20000);
            httpResponse.setMessage("登陆成功");
            hashMap.put("token",JWTUtils.getToken(user));
            httpResponse.setData(hashMap);
        } else {
            httpResponse.setCode(40000);
            httpResponse.setMessage("登陆失败");
            httpResponse.setData("登录失败！账号或者密码不对！");
        }
        return httpResponse;
    }

    @PostMapping("/vue-admin-template/user/logout")
    @ApiOperation(value = "登出接口", notes = "退出登录")
    public HttpResponse logout() {
        httpResponse.setCode(20000);
        httpResponse.setMessage("退出成功");
        httpResponse.setData("");
        return httpResponse;
    }

    @GetMapping("/vue-admin-template/user/info")
    @ApiOperation(value = "用户信息接口", notes = "返回登录用户的基本信息")
    public HttpResponse getInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("introduction", "I am a super administrator");
        map.put("name", "Super Admin");
        httpResponse.setCode(20000);
        httpResponse.setMessage("获取成功");
        httpResponse.setData(map);
        return httpResponse;
    }

    @GetMapping("/vue-admin-template/table/infoList")
    @ApiOperation(value = "获取所有学生列表接口", notes = "返回所有学生信息")
    public HttpResponse getInfoList(UserInfo userInfo) {
        Object data = vueAdminTemplateService.getInfoList(userInfo);
        httpResponse.setCode(20000);
        httpResponse.setMessage("获取成功");
        httpResponse.setData(data);
        return httpResponse;
    }

    @DeleteMapping("/vue-admin-template/table/delete")
    @ApiOperation(value = "删除学生信息接口", notes = "删除某个学生信息")
    @ApiImplicitParam(name = "id", value = "学生id", paramType = "Integer", required = true)
    public HttpResponse deleteInfo(@RequestParam Integer id) {
        httpResponse.setCode(20000);
        httpResponse.setMessage("删除成功");
        httpResponse.setData("");
        vueAdminTemplateService.deleteInfo(id);
        return httpResponse;
    }

    @PostMapping("/vue-admin-template/table/insert")
    @ApiOperation(value = "增加学生信息接口", notes = "增加某个学生信息")
    public HttpResponse insertInfo(UserInfo userInfo) {
        vueAdminTemplateService.insertUser(userInfo);
        httpResponse.setCode(20000);
        httpResponse.setMessage("添加成功");
        httpResponse.setData("");
        return httpResponse;
    }

    @PutMapping("/vue-admin-template/table/edit")
    @ApiOperation(value = "更新学生信息接口", notes = "更新某个学生信息")
    public HttpResponse updateInfo(UserInfo userInfo) {
        vueAdminTemplateService.updateInfo(userInfo);
        httpResponse.setCode(20000);
        httpResponse.setMessage("更新成功");
        httpResponse.setData("");
        return httpResponse;
    }
}
