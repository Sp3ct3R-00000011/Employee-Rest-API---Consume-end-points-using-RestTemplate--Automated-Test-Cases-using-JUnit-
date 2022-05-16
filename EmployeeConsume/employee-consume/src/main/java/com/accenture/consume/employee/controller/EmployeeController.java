package com.accenture.consume.employee.controller;
import com.accenture.consume.employee.service.implementation.EmployeeConsumeServiceImpl;
import com.accenture.consume.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeConsumeServiceImpl employeeConServiceImpl;

    @GetMapping("/consume_employees")
    public List<Employee> get_emp() {
        System.out.println(employeeConServiceImpl.get_employees());
        return employeeConServiceImpl.get_employees();
    }

    @GetMapping("/consume_employees/{id}")
    public Employee get_emp_by_id(@PathVariable String id) {
        return employeeConServiceImpl.get_by_id(id);
    }

    @PostMapping("/consume_employees")
    public Employee add_emp(@RequestBody Employee employee) {
        return employeeConServiceImpl.add_employee(employee);
    }

    @PutMapping("/consume_employees/{id}")
    public Employee updateEmp(@RequestBody Employee employee, @PathVariable String id) {
        return employeeConServiceImpl.updateEmployee(employee, id);
    }


    @DeleteMapping("/consume_employees/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable String id) {
        return employeeConServiceImpl.deleteEmployee(id);

    }

}
