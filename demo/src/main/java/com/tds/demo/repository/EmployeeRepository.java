package com.tds.demo.repository;


import com.tds.demo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

   @Query(value = "Select * from employee where ID=:iD",nativeQuery = true)
   List<EmployeeEntity> findEmployeeId(@Param("iD") Long iD);

   @Query(value = "select * from employee e where e.LEAVE_DATE is null or e.LEAVE_DATE < sysdate",nativeQuery = true)
   List<EmployeeEntity> findemployeestatus();

   @Query(value = "select e.* from employee e , department d , job_title jt \n" +
           "where e.job_title_code = jt.job_title_code and d.department_code=jt.department_code\n" +
           "and d.department_Name=:departmentname",nativeQuery = true)
   List<EmployeeEntity> emplyeebydept(@Param("departmentname") String departmentname);

}
