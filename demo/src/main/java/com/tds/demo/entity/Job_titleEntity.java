package com.tds.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "job_title")
public class Job_titleEntity {
    @Id
    @Column(name = "JOB_TITLE_CODE")
    private Long jobtitlecode;
    @Column(name = "JOB_TITLE_NAME")
    private String jobtitlename;
    @Column(name = "DEPARTMENT_CODE")
    private Long departmentcode;


    public Long getJobtitlecode() {
        return jobtitlecode;
    }

    public void setJobtitlecode(Long jobtitlecode) {
        this.jobtitlecode = jobtitlecode;
    }

    public String getJobtitlename() {
        return jobtitlename;
    }

    public void setJobtitlename(String jobtitlename) {
        this.jobtitlename = jobtitlename;
    }

    public Long getDepartmentcode() {
        return departmentcode;
    }

    public void setDepartmentcode(Long departmentcode) {
        this.departmentcode = departmentcode;
    }
}
