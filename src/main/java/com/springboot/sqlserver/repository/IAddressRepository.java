package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.Address;


@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer>{

}
