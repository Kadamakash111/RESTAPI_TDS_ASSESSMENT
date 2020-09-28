package com.tds.demo.controller;

import com.tds.demo.Tds_Exception;
import com.tds.demo.entity.BadgeEntity;
import com.tds.demo.entity.EmployeeEntity;
import com.tds.demo.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BadgeController {
    @Autowired
    private BadgeRepository badgeRepository;

    /*
   Api to return all the Badge in the Database
   */
    @RequestMapping("/badge")
    public List<BadgeEntity> getBadge() {
        List<BadgeEntity> list=new ArrayList();
        list = badgeRepository.findAll();
        return list;
    }
    /*
   Api to return all the Badge  in the Database were status is active and expiry date is not in past
   */

    @RequestMapping("/badge/active/")
    public List<BadgeEntity> activebage() {
        List<BadgeEntity> list=new ArrayList();
        list =  badgeRepository.activebage();
        if (list.size() > 0) {
            return list;
        }else {
            throw new Tds_Exception(HttpStatus.NOT_FOUND,"No Active Employee");
        }
    }

    /*
  Api to return all the Badge  in the Database when badge number is passed
  */
    @RequestMapping("/badge/{badge_number}")
    public List<BadgeEntity> getbadgenumber(@PathVariable("badge_number") long badge_number) {
        List<BadgeEntity> list = new ArrayList();
        list = badgeRepository.getbadgenumber(badge_number);
        if (list.size() > 0) {
            return list;
        } else if (list.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO department");
        }else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Wrong URl");
        }

    }
}
