package com.wjf.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class UserInfo {
    int id;
    String name;
    String sex;
    int age;
    String phone;
    String address;
    String email;
}
