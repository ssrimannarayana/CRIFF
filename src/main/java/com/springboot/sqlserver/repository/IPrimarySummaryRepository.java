package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.PrimarySummeryPojo;
@Repository
public interface IPrimarySummaryRepository extends JpaRepository<PrimarySummeryPojo, Integer>{

}
