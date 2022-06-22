package com.poc.ems.service;

import com.poc.ems.dao.DepartmentRepo;
import com.poc.ems.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DepartmentService {
    @Autowired
    private DepartmentRepo deptRepo;
    public List<Department> createDept(List<Department> department){
        return deptRepo.saveAll(department);
    }
    public List<Department> getDept( ) {
        return deptRepo.findAll();
    }
    public Department updateDept(Department department) {
        Department oldDept=null;
        Optional<Department> optionalDept=deptRepo.findById(department.getDeptId());
        if(optionalDept.isPresent()) {
            oldDept=optionalDept.get();
                oldDept.setDeptName(department.getDeptName());
                oldDept.setDeptId(department.getDeptId());
            deptRepo.save(oldDept);
        }else {
            return new Department();
        }
        return oldDept;
    }
    public Department getDepartmentId(int id) {
        return deptRepo.findById((id)).orElse(null);
    }

    public String deleteDept(int id) {
        deptRepo.deleteById(id);
        return "Department got deleted";
    }
}


