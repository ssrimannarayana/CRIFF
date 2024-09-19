package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.ResponsePojo;
@Repository
public interface IResponseStatusRepository extends JpaRepository<ResponsePojo, Integer>{

}
