package com.tcbs.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeRequest {
    private String name;
    private String address;
    private Boolean is_manager;
    private Long department_id;
}
