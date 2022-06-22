package com.poc.ems.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Department {
    @Id
    private int DeptId;
    private String DeptName;
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinTable(name="employee_department", joinColumns=@JoinColumn(name="eid",referencedColumnName = "eid"), inverseJoinColumns=@JoinColumn(name="Dept_Id",referencedColumnName = "DeptId"))
//    private List<Employee> employee;
    @OneToMany(mappedBy = "department",cascade = {CascadeType.MERGE})
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private Collection<Employee> employee;
}
