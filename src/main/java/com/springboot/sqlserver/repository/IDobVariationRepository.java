package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.DobVariationPojo;
@Repository
public interface IDobVariationRepository extends JpaRepository<DobVariationPojo, Integer>{

}
