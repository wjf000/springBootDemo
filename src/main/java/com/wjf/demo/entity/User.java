package com.wjf.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    private int id;
    private String name;
    private UserInfo userInfo;
    private List<Depart> departs;
}
