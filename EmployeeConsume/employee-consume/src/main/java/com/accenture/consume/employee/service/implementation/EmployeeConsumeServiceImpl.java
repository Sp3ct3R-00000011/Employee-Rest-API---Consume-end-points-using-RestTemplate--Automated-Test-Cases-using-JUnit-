package com.accenture.consume.employee.service.implementation;
import com.accenture.consume.employee.model.Employee;
import com.accenture.consume.employee.service.EmployeeConsumeService;
import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeConsumeServiceImpl implements EmployeeConsumeService {
    public static final String get_all_employees_path = "http://localhost:8080/employees";
    public static final String api_add_path = "http://localhost:8080/employee";
    public static final String api_path = "http://localhost:8080/employee/{id}";
    static RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Employee> get_employees() {
        ResponseEntity<Employee[]> employees = restTemplate.exchange(get_all_employees_path,HttpMethod.GET,null, Employee[].class);
        System.out.println(new Gson().toJson(employees));
        return Arrays.asList(employees.getBody());
    }

    @Override
    public Employee get_by_id(String id) {
        ResponseEntity<Employee> emp = restTemplate.exchange(api_path, HttpMethod.GET, null, Employee.class, id);
        System.out.println(new Gson().toJson(emp.getBody()));
        return emp.getBody();
    }

    @Override
    public Employee add_employee(Employee employee) {
        ResponseEntity<Employee> emp1 = restTemplate.exchange(api_add_path, HttpMethod.POST, new HttpEntity<>(employee), Employee.class);
        System.out.println(new Gson().toJson(emp1.getBody()));
        return emp1.getBody();
    }

    @Override
    public Employee updateEmployee(Employee employee, String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        ResponseEntity<Employee> exchange = restTemplate.exchange(api_path, HttpMethod.PUT, new HttpEntity<>(employee), Employee.class, params);
        System.out.println("Employee details with Employee ID " + new Gson().toJson(exchange.getBody()) + " Updated Successfully!!!");
        return exchange.getBody();
    }

    @Override
    public ResponseEntity<String> deleteEmployee(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        ResponseEntity<String> exchange = restTemplate.exchange(api_path, HttpMethod.DELETE, null, String.class, params);
        System.out.println("Employee with Employee ID: " + id + " Deleted successfully!!!");
        return exchange;
    }
}
