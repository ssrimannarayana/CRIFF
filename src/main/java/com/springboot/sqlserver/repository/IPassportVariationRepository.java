package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.PassporVariationPojo;
@Repository
public interface IPassportVariationRepository extends JpaRepository<PassporVariationPojo, Integer>{

}
