package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.SecondarySummary;
@Repository
public interface ISecondarySummaryRepository extends JpaRepository<SecondarySummary, Integer>{

}
