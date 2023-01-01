package com.wjf.demo.service.impl;

import com.wjf.demo.dao.DepartMapper;
import com.wjf.demo.dao.UserMapper;
import com.wjf.demo.entity.Depart;
import com.wjf.demo.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {
    @Resource
    DepartMapper departMapper;

    @Override
    public List<Depart> getDepart(Depart depart) {
        return departMapper.getDepart(depart);
    }
}
