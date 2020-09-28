package com.tds.demo.repository;

import com.tds.demo.entity.DepartmentEntity;
import com.tds.demo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    @Query(value = "select count(d.department_Name) from department d where d.department_Name =:departmentname",nativeQuery = true)
    Integer deptexists(@Param("departmentname") String departmentname);
}
