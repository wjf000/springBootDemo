package com.wjf.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_info")
public class UserInfo {
    int id;
    int age;
    String pwd;
    String sex;
    String phone;
    String address;
    String wx;
    String qq;
}
