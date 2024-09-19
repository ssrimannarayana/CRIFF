package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.DerivedAttributesPojo;

@Repository
public interface IDerivedAttrubutesRepository extends JpaRepository<DerivedAttributesPojo, Integer>{

}
