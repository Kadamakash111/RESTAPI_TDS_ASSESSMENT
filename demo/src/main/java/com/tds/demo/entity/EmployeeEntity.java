package com.tds.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "BADGE_NUMBER")
    private Long badgenumber;
    @Column(name = "COUNTRY_CODE")
    private  String countrycode;
    @Column(name = "JOB_TITLE_CODE")
    private Long jobtitilecode;
    @Column(name = "START_DATE")
    private Date startdate;
    @Column(name = "LEAVE_DATE")
    private Date leavedate;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getBadgenumber() {
        return badgenumber;
    }

    public void setBadgenumber(Long badgenumber) {
        this.badgenumber = badgenumber;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public Long getJobtitilecode() {
        return jobtitilecode;
    }

    public void setJobtitilecode(Long jobtitilecode) {
        this.jobtitilecode = jobtitilecode;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
