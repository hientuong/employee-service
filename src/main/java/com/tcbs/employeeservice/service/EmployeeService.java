package com.tcbs.employeeservice.service;

import com.tcbs.employeeservice.dto.EmployeeRequest;
import com.tcbs.employeeservice.model.Department;
import com.tcbs.employeeservice.model.Employee;
import com.tcbs.employeeservice.repository.DepartmentRepository;
import com.tcbs.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findByNameOrAddressOrDepartmentName(String name, String address, String departmentName) {
        return employeeRepository.findByNameOrAddressOrDepartmentName(name, address, departmentName);
    }

    public Employee createEmployee(EmployeeRequest employeeRequest, Department department) {
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setAddress(employeeRequest.getAddress());
        employee.setIs_manager(employeeRequest.getIs_manager());
        employee.setDepartment(department);

        Employee employeeRes = employeeRepository.save(employee);

        return employeeRes;
    }

    public Employee updateEmployee(Long id, EmployeeRequest employeeRequest, Department department) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow();
        employee.setName(employeeRequest.getName());
        employee.setAddress(employeeRequest.getAddress());
        employee.setIs_manager(employeeRequest.getIs_manager());
        employee.setDepartment(department);

        Employee employeeRes = employeeRepository.save(employee);

        return employeeRes;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
