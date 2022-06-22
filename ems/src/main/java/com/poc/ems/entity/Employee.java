package com.poc.ems.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Employee")
@Table(name="Employee")
public class Employee implements Serializable {
  @Id
  private int eId;
  private String name;
  private int age;
  private int managerId;
  private double salary;
//  Certification
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "eId", referencedColumnName = "eId",nullable = false)
  private List<Certification> emp_cert;

  //Department
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinTable(name = "employee_department", joinColumns = {
      @JoinColumn(name = "eId", referencedColumnName = "eId")}, inverseJoinColumns = {
      @JoinColumn(name = "Dept_Id", referencedColumnName = "DeptId")})
  private Department department;


}
