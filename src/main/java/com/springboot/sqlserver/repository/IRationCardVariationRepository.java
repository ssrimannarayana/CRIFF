package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.RationCardVariationPojo;
@Repository
public interface IRationCardVariationRepository extends JpaRepository<RationCardVariationPojo, Integer>{

}
