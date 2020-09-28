package com.tds.demo.controller;

import com.tds.demo.entity.EmployeeEntity;
import com.tds.demo.entity.Job_titleEntity;
import com.tds.demo.repository.Job_titleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Job_titleController {
    @Autowired
    private Job_titleRepository job_titleRepository;

    /*
       Api to return all the job titles  in the Database
       */
    @RequestMapping("/job_titles")
    public List<Job_titleEntity> getJob_titles() {
        List<Job_titleEntity> list=new ArrayList();
        list = job_titleRepository.findAll();
        return list;
    }

    @RequestMapping("/job_titles/:department_name/{departmentname}")
    public List<Job_titleEntity> jobtitlebydept(@PathVariable("departmentname") String departmentname) {
        List<Job_titleEntity> list = new ArrayList();
        list =  job_titleRepository.jobtitlebydept(departmentname);
        if (list.size() > 0) {
            return list;
        } else if (list.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Job title in department");
        }else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Wrong URl");
        }
    }
}
