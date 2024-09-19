package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.Summary;
@Repository
public interface ISummaryRepository extends JpaRepository<Summary, Integer>{

}
