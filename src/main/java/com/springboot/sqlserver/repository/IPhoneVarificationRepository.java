package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.PhoneVariationPojo;
@Repository
public interface IPhoneVarificationRepository extends JpaRepository<PhoneVariationPojo, Integer>{

}
