package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.SecondaryAccountsSummary;
@Repository
public interface ISecondaryAcSummaryRepository extends JpaRepository<SecondaryAccountsSummary, Integer>{

}
