package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.GrpPrimarySummeryPojo;
@Repository
public interface IGrpPrimaryRepository extends JpaRepository<GrpPrimarySummeryPojo, Integer>{

}
