package com.springboot.sqlserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sqlserver.entity.DrivingLicenseVariationPojo;
@Repository
public interface IDlVariationRepository extends JpaRepository<DrivingLicenseVariationPojo, Integer>{

}
