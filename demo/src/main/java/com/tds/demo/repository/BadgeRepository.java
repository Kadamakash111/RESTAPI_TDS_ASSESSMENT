package com.tds.demo.repository;

import com.tds.demo.entity.BadgeEntity;
import com.tds.demo.entity.BadgeEntity;
import com.tds.demo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BadgeRepository extends JpaRepository<BadgeEntity, Long> {

    @Query(value = "select * from badge b where b.badge_status = 'Active' and to_char(b.badge_expiry_date,'dd/mm/rrrr') < to_char(sysdate,'dd/mm/rrrr')",nativeQuery = true)
    List<BadgeEntity> activebage();

    @Query(value = "Select * from badge where badge_NUMBER=:badge_number",nativeQuery = true)
    List<BadgeEntity> getbadgenumber(@Param("badge_number") Long badge_number);

}
