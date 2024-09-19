package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.GrpSummary;
@Repository
public interface IGrpSummaryRepository extends JpaRepository<GrpSummary, Integer>{

}
