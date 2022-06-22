package com.poc.ems.service;

import com.poc.ems.dao.EmployeeRepo;
import com.poc.ems.entity.Employee;
import com.poc.ems.entity.Certification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService {
  @Autowired
  private EmployeeRepo employeeRepo;
//    @Autowired private EmployeeCertificationRepo empCertrepo;
//    @Autowired private DepartmentRepo depRepo;
//    @Autowired private Certification employeeCertification;
//    @Autowired private DepartmentService departmentService;

  //    public Employee createEmp(Employee employee) {
//        return employeeRepo.save(employee);
//
//    }
  public Employee createCertificate(Employee employee) {
    Optional<Employee> optionalEmployee = employeeRepo.findById(employee.getEId());
    Employee oldEmp = optionalEmployee.get();
    List<Certification> oldCertificationList;
    oldCertificationList = oldEmp.getEmp_cert();
    List<Certification> newCertificates = employee.getEmp_cert();
    for (int i = 0; i < newCertificates.size(); i++) {
      oldCertificationList.add(newCertificates.get(i));
    }
    oldEmp.setEmp_cert(oldCertificationList);
    return employeeRepo.save(oldEmp);

  }

  public List<Employee> createEmps(List<Employee> employees) {
    return employeeRepo.saveAll(employees);

  }

  public Employee getEmpId(int id) {
    return employeeRepo.findById(id).orElse(null);
  }

  public String getEmployeeManager(int employeeId) {
    Employee emp = employeeRepo.findById(employeeId).orElse(null);
    int data=emp.getManagerId();
    return employeeRepo.findManagerName(data);
  }

  public Employee updateEmp(Employee emp) {
    Employee oldEmp = null;
    Optional<Employee> optionalEmp = employeeRepo.findById(emp.getEId());
    if (optionalEmp.isPresent()) {
      oldEmp = optionalEmp.get();
      if (!emp.getName().isEmpty()) {
        oldEmp.setName(emp.getName());
      }
      if (emp.getAge() != 0) {
        oldEmp.setAge(emp.getAge());
      }
      if (emp.getManagerId() != 0) {
        oldEmp.setManagerId(emp.getManagerId());
      }
      if (emp.getSalary() != 0) {
        oldEmp.setSalary(emp.getSalary());
      }
      if (emp.getDepartment() != null) {
        oldEmp.setDepartment(emp.getDepartment());
      }
      if (emp.getEmp_cert() != null) {
//        List<Certification>oldEmployeeCertificationList;
//        oldEmployeeCertificationList=oldEmp.getEmp_cert();
//        List<Certification>updateCertificates=emp.getEmp_cert();
//        for(int i=0;i<updateCertificates.size();i++){
//            oldEmployeeCertificationList.add(updateCertificates.get(i));
//        }
        oldEmp.setEmp_cert(emp.getEmp_cert());
      }
      employeeRepo.save(oldEmp);

    } else {
      return new Employee();
    }
    return oldEmp;
  }
//    public void updateEmp(Employee emp,int id){
//        Optional<Employee>optionalEmp= Optional.ofNullable(employeeRepo.findById(id).orElse(null));
//        oldEmp.setEid();
//    }

  public String deleteEmpById(int id) {
    employeeRepo.deleteById(id);
    return "User got deleted";
  }
}