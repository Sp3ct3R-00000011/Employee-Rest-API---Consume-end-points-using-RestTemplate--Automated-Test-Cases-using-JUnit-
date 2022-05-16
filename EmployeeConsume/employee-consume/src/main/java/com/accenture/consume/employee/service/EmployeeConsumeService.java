package com.accenture.consume.employee.service;

import com.accenture.consume.employee.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeConsumeService {

    List<Employee> get_employees();
    Employee get_by_id(String id);
    Employee add_employee(Employee employee);
    Employee updateEmployee(Employee employee, String id);
    ResponseEntity<String> deleteEmployee(String id);


}
