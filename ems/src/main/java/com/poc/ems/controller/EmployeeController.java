package com.poc.ems.controller;

import com.poc.ems.entity.Employee;
import com.poc.ems.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
public class EmployeeController {
  Logger logger = LoggerFactory.getLogger(EmployeeController.class);
  @Autowired
  private EmployeeService employeeService;

//    @PostMapping("/addEmp")
//    public Employee addEmp(@RequestBody Employee emp) {
//        logger.trace("Employee Added");
//        return employeeService.createEmp(emp);
//    }

  @PostMapping("/addEmps")
  public List<Employee> addEmps(@RequestBody List<Employee> emps) {
    logger.info("Employees Added");
    return employeeService.createEmps(emps);
  }

  @PostMapping("/addCertificate")
  public Employee addCertificate(@RequestBody Employee employee) {
    return employeeService.createCertificate(employee);
  }

  @GetMapping("/emp/{id}")
  public Employee getEmpById(@PathVariable int id) {

    logger.info("Getting the details of an Employee with employee_id={}",id);
    return employeeService.getEmpId(id);
  }

  @PostMapping("/{employeeId}/manager")
  public String getEmployeeManager(@PathVariable int employeeId) {
    log.info("Getting Name of Manager of Employee with employee_id = {}", employeeId);
    return employeeService.getEmployeeManager(employeeId);
  }

//  @GetMapping("/employees")
//  public List<Employee> readData () {
//    return employeeService.getAllRecords();
//
//  }

//    @GetMapping("/emps")
//    public List<Employee> getAllEmps() {
//
//        logger.trace("Get All Employees");return employeeService.getEmps();
//    }

  @PutMapping("/updateEmp/{id}")
  public Employee updateEmp(@RequestBody Employee emp) {

    logger.info("Updated Employee");
    return employeeService.updateEmp(emp);
  }

  @DeleteMapping("/emp/{id}")
  public String deleteEmp(@PathVariable int id) {

    logger.info("Deleted Employee");
    return employeeService.deleteEmpById(id);
  }
}
