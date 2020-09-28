package com.tds.demo.repository;

import com.tds.demo.entity.EmployeeEntity;
import com.tds.demo.entity.Job_titleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Job_titleRepository extends JpaRepository<Job_titleEntity, Long> {

    @Query(value = "select * from job_title jt,department d where jt.department_code = d.department_code and d.department_Name=:departmentname",nativeQuery = true)
    List<Job_titleEntity> jobtitlebydept(@Param("departmentname") String departmentname);
}

