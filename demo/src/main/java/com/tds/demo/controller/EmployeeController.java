package com.tds.demo.controller;

import com.tds.demo.CountryList;
import com.tds.demo.Tds_Exception;
import com.tds.demo.entity.EmployeModel;
import com.tds.demo.entity.EmployeeEntity;
import com.tds.demo.repository.DepartmentRepository;
import com.tds.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private RestTemplate restTemplate;


  /*
   Api to return all the employee in the Database
   */
    @RequestMapping("/Employee/")
    public List<EmployeModel> getEmployee() {
        RestTemplate template = new RestTemplate();
        List<EmployeeEntity> list = new ArrayList();
        List<EmployeModel> employeModelList = new ArrayList();
        list = employeeRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            EmployeeEntity entity = list.get(i);
            EmployeModel model = new EmployeModel();
            StringBuffer url = new StringBuffer();
            url.append("https://restcountries.eu/rest/v2/alpha/");
            url.append(list.get(i).getCountrycode());
            CountryList response = template.getForObject(url.toString(), CountryList.class);
            model.setId(entity.getId());
            model.setFirstname(entity.getFirstname());
            model.setLastname(entity.getLastname());
            model.setBadgenumber(entity.getBadgenumber());
            model.setCountryname(response.getName());
            model.setJobtitilecode(entity.getJobtitilecode());
            model.setLeavedate(entity.getLeavedate());
            model.setStartdate(entity.getStartdate());
            employeModelList.add(model);
        }
        return employeModelList;

    }

    /*
   Api to return all the employee in the Database with Employee id passed
   */
    @RequestMapping("/Employee/{iD}")
    public List<EmployeeEntity> getEmployeebyid(@PathVariable("iD") long iD) {
        return employeeRepository.findEmployeeId(iD);

    }

    /*
   Api to return all the active employees with Leave date is null or Set in the past employee in the Database
   */
    @RequestMapping("/Employees/active/")
    public List<EmployeeEntity> findemployeestatus() {
        List<EmployeeEntity> list=new ArrayList();
        list =  employeeRepository.findemployeestatus();
        if (list.size() > 0) {
            return list;
        }else {
            throw new Tds_Exception(HttpStatus.NOT_FOUND,"No Active Employee");
        }
        }
    /*
       Api to return all the employee in the Database department wise
       */
    @RequestMapping("/Employee/department_name/{departmentname}")
    public List<EmployeeEntity> emplyeebydept(@PathVariable("departmentname") String departmentname) {
        List<EmployeeEntity> list = new ArrayList();
        int deptcount = departmentRepository.deptexists(departmentname);
        System.out.println(deptcount);
        list = employeeRepository.emplyeebydept(departmentname);

        if (list.size() > 0) {
            return list;
        } else if (deptcount == 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "NO department");
        } else if (deptcount == 1 && list.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO department");
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Wrong URl");
        }

    }


    }
