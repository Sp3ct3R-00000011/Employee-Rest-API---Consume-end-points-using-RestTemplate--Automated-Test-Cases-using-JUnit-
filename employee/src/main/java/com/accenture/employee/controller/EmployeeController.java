package com.accenture.employee.controller;
import com.accenture.employee.service.implementation.EmployeeServiceImplementation;
import com.accenture.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImplementation employeeServiceImpl;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {

        return employeeServiceImpl.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeServiceImpl.getEmployee(id);

    }

    @GetMapping("/employee")
    public Employee getEmployee_param(@RequestParam String id) {
        return employeeServiceImpl.getEmployee(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeServiceImpl.addEmployee(employee);
    }

    @PutMapping("/employee")

    public Employee updateEmployee(@RequestBody Employee employee, @RequestParam String id) {

        return employeeServiceImpl.updateEmployee(employee, id);
    }

    @PutMapping("/employee/{id}")

    public Employee updateEmployee_path(@RequestBody Employee employee, @PathVariable String id) {

        return employeeServiceImpl.updateEmployee(employee, id);
    }

    @DeleteMapping("/employee/{id}")
    public List<Employee> deleteEmployee(@PathVariable String id) {

        return employeeServiceImpl.deleteEmployee(id);
    }

    @DeleteMapping("/employee")
    public List<Employee> deleteEmployee_param(@RequestParam String id) {
        return employeeServiceImpl.deleteEmployee(id);

    }
}