package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.ScorePojo;
@Repository
public interface IScoreRepository extends JpaRepository<ScorePojo, Integer>{

}
