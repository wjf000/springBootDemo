package com.wjf.demo.service;

import com.wjf.demo.entity.UserInfo;

import java.util.List;

public interface VueAdminTemplateService {

    List<UserInfo> getInfoList(UserInfo userInfo);

    int deleteInfo(Integer id);

    int insertUser(UserInfo userInfo);

    int updateInfo(UserInfo userInfo);
}
