package com.tds.demo.entity;

import java.util.Date;

public class EmployeModel {
    private long id;
    private String firstname;
    private String lastname;
    private Long badgenumber;
    private  String countryname;
    private Long jobtitilecode;
    private Date startdate;
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

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
