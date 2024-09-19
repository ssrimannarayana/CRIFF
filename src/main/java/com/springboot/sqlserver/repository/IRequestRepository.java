package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.RequestPojo;

@Repository
public interface IRequestRepository extends JpaRepository<RequestPojo, Integer>{

}
