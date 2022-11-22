package com.wjf.demo.dao;

import com.wjf.demo.entity.Depart;

import java.util.List;

public interface DepartMapper {
    /**
     * 获取某个用户下的所有部门
     * @param depart
     * @return
     */
    List<Depart> getDepart(Depart depart);
}
