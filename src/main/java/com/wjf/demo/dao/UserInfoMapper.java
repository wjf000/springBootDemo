package com.wjf.demo.dao;

import com.wjf.demo.entity.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    List<UserInfo> findInfoList(UserInfo userInfo);

    int deleteInfo(Integer id);

    int insertInfo(UserInfo userInfo);

    int updateInfo(UserInfo userInfo);
}
