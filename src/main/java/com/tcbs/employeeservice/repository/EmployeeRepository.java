package com.tcbs.employeeservice.repository;

import com.tcbs.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentName(String department_name);

    List<Employee> findByNameOrAddress(String name, String address);
}
