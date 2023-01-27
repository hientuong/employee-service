package com.tcbs.employeeservice.controller;

import com.tcbs.employeeservice.dto.EmployeeRequest;
import com.tcbs.employeeservice.model.Department;
import com.tcbs.employeeservice.model.Employee;
import com.tcbs.employeeservice.service.DepartmentService;
import com.tcbs.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class EmployeeController {
    private final EmployeeService employeeService;

    private final DepartmentService departmentService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrAddressOrDepartmentName(@RequestParam(value = "name", required = false) String name,
                                                             @RequestParam(value = "address", required = false) String address,
                                                             @RequestParam(value = "department_name", required = false) String department_name) {
        List<Employee> employees = employeeService.findByNameOrAddressOrDepartmentName(name, address, department_name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/department/{department_id}/employee")
    public ResponseEntity<Employee> createEmployee(@PathVariable(value = "department_id") Long departmentId, @RequestBody EmployeeRequest employeeRequest) {
        Department department = departmentService.getDepartmentById(departmentId);
        Employee employee = employeeService.createEmployee(employeeRequest, department);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody EmployeeRequest employeeRequest) {
        Department department = departmentService.getDepartmentById(employeeRequest.getDepartment_id());
        Employee employee = employeeService.updateEmployee(id, employeeRequest, department);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
