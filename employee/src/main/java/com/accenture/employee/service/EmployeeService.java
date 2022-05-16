package com.accenture.employee.service;

import com.accenture.employee.model.Employee;
import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployee(String empID);
    Employee updateEmployee(Employee emp, String empID);
    List<Employee> deleteEmployee(String empID);
}
