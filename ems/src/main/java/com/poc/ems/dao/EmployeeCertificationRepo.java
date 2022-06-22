package com.poc.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poc.ems.entity.Certification;

public interface EmployeeCertificationRepo extends JpaRepository<Certification,Integer>{
}
