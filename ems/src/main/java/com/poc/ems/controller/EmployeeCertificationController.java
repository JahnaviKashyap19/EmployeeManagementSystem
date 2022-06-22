package com.poc.ems.controller;

import com.poc.ems.entity.Certification;
import com.poc.ems.service.EmployeeCertificationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//creating RestController
@Slf4j
@RestController
public class EmployeeCertificationController
{
    Logger logger = LoggerFactory.getLogger(EmployeeCertificationController.class);
    @Autowired
    private EmployeeCertificationService employeeCertificationService;
//    @PostMapping("/AddEmployeeCertifications")
//    public List<Certification> addEmpCerts(@RequestBody List<Certification> emps) {
//        logger.info("Employee Certification Added");
//        return employeeCertificationService.createEmp_Certs(emps);
//    }
    @GetMapping("/GetEmployeeCertification/{id}")
    public Certification getEmpCertById(@PathVariable int id) {
        logger.info("Employee Certification Received");
        return employeeCertificationService.getCertId(id);
    }
    //    @GetMapping("/GetEmployeeCertifications")
//    public List<Certification> getAllEmpCerts() {
//        return employeeCertificationService.getCerts();
//    }
    @PutMapping("/UpdateEmployeeCertifications")
    public Certification updateEmpCerts(@RequestBody Certification emp) {
        logger.info("Employee Certification Updated");
        return employeeCertificationService.updateCert(emp);
    }

    @DeleteMapping("/DelEmployeeCertification/{id}")
    public String deleteEmpCert(@PathVariable int id) {

        logger.info("Employee Certification Deleted");
        return employeeCertificationService.deleteEmpCert(id);
    }
}

