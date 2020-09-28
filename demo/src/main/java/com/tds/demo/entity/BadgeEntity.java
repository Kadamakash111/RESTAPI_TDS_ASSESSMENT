package com.tds.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "BADGE")
public class BadgeEntity {
    @Id
    @Column(name = "BADGE_NUMBER")
    private Long badgenumber;
    @Column(name = "BADGE_STATUS")
    private String badgestatus;
    @Column(name = "BADGE_EXPIRY_DATE")
    private Date expirydate;

    public Long getBadgenumber() {
        return badgenumber;
    }

    public void setBadgenumber(Long badgenumber) {
        this.badgenumber = badgenumber;
    }

    public String getBadgestatus() {
        return badgestatus;
    }

    public void setBadgestatus(String badgestatus) {
        this.badgestatus = badgestatus;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }
}
