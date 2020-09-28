package com.tds.demo.controller;

import com.tds.demo.entity.DepartmentEntity;
import com.tds.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping("/department")
    public List<DepartmentEntity> getDepartment() {
        List<DepartmentEntity> list=new ArrayList();
        list = departmentRepository.findAll();
        return list;

    }
}
