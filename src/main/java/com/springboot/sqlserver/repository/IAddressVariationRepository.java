package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.AddressVariationPojo;

@Repository
public interface IAddressVariationRepository extends JpaRepository<AddressVariationPojo, Integer>{

}
