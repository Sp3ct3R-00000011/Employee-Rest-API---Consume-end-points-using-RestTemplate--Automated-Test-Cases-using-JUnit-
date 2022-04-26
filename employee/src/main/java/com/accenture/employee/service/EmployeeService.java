package com.accenture.employee.service;

import com.accenture.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private static List<Employee> employeeList = new ArrayList<>(Arrays.asList(

            new Employee("E1", "John", "SE", 9, 4500000, "Python", "n", "P2", "Bengaluru"),
            new Employee("E2", "Harry", "ASE", 12, 500000, "Java", "y", "P3", "Chennai"),
            new Employee("E3", "Potter", "Manager", 8, 9000000, "Big Data", "n", "P4", "Gurgaon")));

    public Employee addEmployee(Employee employee) {

        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployee(String empID) {
        Employee employee = null;
        for (Employee e : employeeList) {
            if (e.getEmpID().equals(empID)) {
                employee = e;
                break;
            }
        }
        return employee;
    }

    public Employee updateEmployee(Employee emp, String empID) {
        final Employee[] temp = new Employee[1];
        employeeList.forEach(e -> {
            if (e.getEmpID().equals(empID)) {
                if (emp.getDesignation() != null) e.setDesignation(emp.getDesignation());
                if (emp.getCareer_lvl() != 0) e.setCareer_lvl(emp.getCareer_lvl());
                if (emp.getSalary() != 0) e.setSalary(emp.getSalary());
                if (emp.getName() != null) e.setName(emp.getName());
                if (emp.getPrimary_skill() != null) e.setPrimary_skill(emp.getPrimary_skill());
                if (emp.getLocation() != null) e.setLocation(emp.getLocation());
                if (emp.getProject_assigned() != null) e.setProject_assigned(emp.getProject_assigned());
                if (emp.getSkill_proficiency() != null) e.setSkill_proficiency(emp.getSkill_proficiency());
                temp[0] = e;
            }
        });
        return temp[0];
    }

    public List<Employee> deleteEmployee(String empID) {
        employeeList.removeIf(e -> (e.getEmpID().equals(empID)));
        return employeeList;
    }
}

