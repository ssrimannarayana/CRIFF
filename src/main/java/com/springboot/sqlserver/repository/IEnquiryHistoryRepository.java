package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.EnquiryHistoryPojo;

@Repository
public interface IEnquiryHistoryRepository extends JpaRepository<EnquiryHistoryPojo, Integer>{

}
