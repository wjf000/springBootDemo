package com.wjf.demo.service.impl;

import com.wjf.demo.dao.UserInfoMapper;
import com.wjf.demo.entity.UserInfo;
import com.wjf.demo.service.VueAdminTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VueAdminTemplateImpl implements VueAdminTemplateService {

    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getInfoList(UserInfo userInfo) {
        return userInfoMapper.findInfoList(userInfo);
    }

    @Override
    public int deleteInfo(Integer id) {
        return userInfoMapper.deleteInfo(id);
    }

    @Override
    public int insertUser(UserInfo userInfo) {
        return userInfoMapper.insertInfo(userInfo);
    }

    @Override
    public int updateInfo(UserInfo userInfo) {
        return userInfoMapper.updateInfo(userInfo);
    }
}
