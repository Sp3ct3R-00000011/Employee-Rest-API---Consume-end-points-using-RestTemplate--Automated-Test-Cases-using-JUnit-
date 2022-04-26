package com.accenture.employee.controller;

import com.accenture.employee.service.EmployeeService;
import com.accenture.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.getEmployee(id);

    }

    @GetMapping("/employee")
    public Employee getEmployee_param(@RequestParam String id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employee")

    public Employee updateEmployee(@RequestBody Employee employee, @RequestParam String id) {

        return employeeService.updateEmployee(employee, id);
    }

    @PutMapping("/employee/{id}")

    public Employee updateEmployee_path(@RequestBody Employee employee, @PathVariable String id) {

        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/employee/{id}")
    public List<Employee> deleteEmployee(@PathVariable String id) {

        return employeeService.deleteEmployee(id);
    }

    @DeleteMapping("/employee")
    public List<Employee> deleteEmployee_param(@RequestParam String id) {
        return employeeService.deleteEmployee(id);

    }
}