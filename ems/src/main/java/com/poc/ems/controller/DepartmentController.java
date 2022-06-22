package com.poc.ems.controller;

import com.poc.ems.entity.Department;
import com.poc.ems.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController

public class DepartmentController {
  Logger logger = LoggerFactory.getLogger(DepartmentController.class);
  @Autowired
  private DepartmentService deptService;

  @PostMapping("/AddDepartments")
  public List<Department> addDept(@RequestBody List<Department> department) {
    logger.info("Department Added");
    return deptService.createDept(department);
  }
//    @GetMapping("/GetDepartments")
//    public List<Department> getDepartment() {
//        logger.trace("Get Department");

  //        return deptService.getDept();
//    }
  @GetMapping("/Dept/{id}")
  public Department getDeptId(@PathVariable int id) {
    logger.info("Get Department Id");
    return deptService.getDepartmentId(id);
  }

  @PutMapping("/UpdateDepartment")
  public Department updateDepartment(@RequestBody Department dep) {

    logger.info("Department Updated");
    return deptService.updateDept(dep);
  }

  @DeleteMapping("/DeleteDepartment/{id}")
  public String deleteDept(@PathVariable int id) {

    logger.info("Deleted Department");
    return deptService.deleteDept(id);
  }

}
