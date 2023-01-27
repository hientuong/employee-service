package com.tcbs.employeeservice.repository;

import com.tcbs.employeeservice.model.Department;
import com.tcbs.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameOrAddressOrDepartmentName(String name, String address, String department_name);
}
