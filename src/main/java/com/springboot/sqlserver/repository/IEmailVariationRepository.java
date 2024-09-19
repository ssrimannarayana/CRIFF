package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.EmailVariationPojo;
@Repository
public interface IEmailVariationRepository extends JpaRepository<EmailVariationPojo, Integer>{

}
