package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.GrpSecondarySummary;
@Repository
public interface IGrpSecondarySummaryRepository extends JpaRepository<GrpSecondarySummary, Integer>{

}
