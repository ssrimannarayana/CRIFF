package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.VoterIdVariationPojo;
@Repository
public interface IVoterVariationRepository extends JpaRepository<VoterIdVariationPojo, Integer>{

}
