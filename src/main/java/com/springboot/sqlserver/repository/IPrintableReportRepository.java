package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.PrintableReportPojo;
@Repository
public interface IPrintableReportRepository extends JpaRepository<PrintableReportPojo, Integer>{

}
