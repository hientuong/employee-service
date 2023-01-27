package com.tcbs.employeeservice.service;

import com.tcbs.employeeservice.dto.DepartmentRequest;
import com.tcbs.employeeservice.model.Department;
import com.tcbs.employeeservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService  {

    private final DepartmentRepository departmentRepository;

    public Department createDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setName(departmentRequest.getName());

        departmentRepository.save(department);
        return department;
    }

    public Department getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow();

        return department;
    }
}
