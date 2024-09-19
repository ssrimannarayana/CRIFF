package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.PanVariationsPojo;

@Repository
public interface IPanVariationRepository extends JpaRepository<PanVariationsPojo, Integer>{

}
