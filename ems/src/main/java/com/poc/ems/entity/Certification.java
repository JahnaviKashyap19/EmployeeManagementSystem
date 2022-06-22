package com.poc.ems.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Certification {
  @Id
  private int certId;
  private String cert_name;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private String certExpDate;
//    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "employee_certification", joinColumns = @JoinColumn(name = "certId", referencedColumnName = "certId", nullable = false),
//        inverseJoinColumns = @JoinColumn(name = "eid", referencedColumnName = "eid", nullable = false))
//    @JsonIgnoreProperties("emp_Cert")

}

