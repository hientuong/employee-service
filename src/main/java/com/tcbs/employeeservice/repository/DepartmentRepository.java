package com.tcbs.employeeservice.repository;

import com.tcbs.employeeservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
