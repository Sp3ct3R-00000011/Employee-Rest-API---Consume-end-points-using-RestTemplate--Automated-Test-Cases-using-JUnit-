package com.accenture.consume.employee.controller;
import com.google.gson.Gson;
import com.accenture.consume.employee.model.Employee;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    public static final String get_all_employees_path = "http://localhost:8080/employees";
    public static final String api_add_path = "http://localhost:8080/employee";
    public static final String api_path = "http://localhost:8080/employee/{id}";

    static RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/consume_employees")
    public List<Employee> getemployees() {
        Employee[] employees = restTemplate.getForObject(get_all_employees_path, Employee[].class);
        System.out.println(new Gson().toJson(employees));
        return Arrays.asList(employees);
    }

    @GetMapping("/consume_employees/{id}")
    public Employee get_by_id(@PathVariable String id) {
        Employee emp = restTemplate.getForObject(api_path, Employee.class, id);
        System.out.println(emp.getEmpID());
        return emp;
    }

    @PostMapping("/consume_employees")
    public Employee add_employee(@RequestBody Employee employee) {
        Employee emp1 = restTemplate.postForObject(api_add_path, employee, Employee.class);
        System.out.println(new Gson().toJson(emp1));
        return emp1;
    }

    @PutMapping("/consume_employee/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
        restTemplate.put(api_path, employee, id);
        System.out.println("Employee details with Employee ID " + id + " Updated Successfully!!!");
    }

    @PutMapping("/consume_employees/{id}")
    public Employee updateEmployee_ex(@RequestBody Employee employee, @PathVariable String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        ResponseEntity<Employee> exchange = restTemplate.exchange(api_path, HttpMethod.PUT, new HttpEntity<>(employee), Employee.class, params);
        System.out.println("Employee details with Employee ID " + new Gson().toJson(exchange.getBody()) + " Updated Successfully!!!");
        return exchange.getBody();
    }

    @DeleteMapping("/consume_employee/{id}")
    public String deleteEmp(@PathVariable String id) {
        restTemplate.delete(api_path, id);
        return "Deleted Successfully!!!";
    }

    @DeleteMapping("/consume_employees/{id}")
    public ResponseEntity<String> deleteEmp_ex(@PathVariable String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        ResponseEntity<String> exchange = restTemplate.exchange(api_path, HttpMethod.DELETE, null, String.class, params);
        System.out.println("Employee with Employee ID: " + id + " Deleted successfully!!!");
        return exchange;

    }

}
