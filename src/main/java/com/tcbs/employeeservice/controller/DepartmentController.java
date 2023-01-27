package com.tcbs.employeeservice.controller;

import com.tcbs.employeeservice.dto.DepartmentRequest;
import com.tcbs.employeeservice.model.Department;
import com.tcbs.employeeservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/department")
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentRequest departmentRequest) {
        Department department = departmentService.createDepartment(departmentRequest);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
}
