package com.wjf.demo.controller;

import com.wjf.demo.entity.Depart;
import com.wjf.demo.service.DepartService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "部门相关接口")
public class DepartController {

    @Autowired
    DepartService departService;

    @GetMapping("/getDepart")
    public List<Depart> getDepart(Depart depart){
        return departService.getDepart(depart);
    }
}
