package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface INameVariationRepository extends JpaRepository<NameVariationPojo, Integer>{

}
