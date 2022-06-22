package com.poc.ems.service;

import com.poc.ems.dao.EmployeeCertificationRepo;
import com.poc.ems.entity.Certification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeCertificationService {
    @Autowired
    private EmployeeCertificationRepo employeeCertificationRepo;

//    public List<Certification> createEmp_Certs(List<Certification> empCert) {
//        return employeeCertificationRepo.saveAll(empCert);
//
//    }
    public Certification getCertId(int id) {
        return employeeCertificationRepo.findById(id).orElse(null);
    }
    //    public List<Certification> getCerts( ) {
//        return employeeCertificationRepo.findAll();
//    }
    public Certification updateCert(Certification certification) {
        Certification oldEmc=null;
        Optional<Certification> optionalEmp=employeeCertificationRepo.findById(certification.getCertId());
        if(optionalEmp.isPresent()) {
            oldEmc=optionalEmp.get();
            if(!certification.getCert_name().isEmpty())
                oldEmc.setCert_name(certification.getCert_name());
            if(!certification.getCertExpDate().isEmpty())
                oldEmc.setCertExpDate(certification.getCertExpDate());
            employeeCertificationRepo.save(oldEmc);
        }else {
            return new Certification();
        }
        return oldEmc;
    }
    public String deleteEmpCert(int id) {
        employeeCertificationRepo.deleteById(id);
        return "User got deleted";
    }
}
