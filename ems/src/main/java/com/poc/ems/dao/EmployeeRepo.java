package com.poc.ems.dao;

import com.poc.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
  @Query(nativeQuery = true, value = "select m.NAME from Employee m join Employee e on m.E_ID=:mId")
  String findManagerName(@Param("mId") int mId);
}
