package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.Alerts;

@Repository
public interface IAlertRepository extends JpaRepository<Alerts, Integer>{

}
