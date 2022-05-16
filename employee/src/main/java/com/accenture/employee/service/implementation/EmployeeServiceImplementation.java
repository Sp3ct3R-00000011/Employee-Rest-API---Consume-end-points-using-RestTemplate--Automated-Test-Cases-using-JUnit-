package com.accenture.employee.service.implementation;

import com.accenture.employee.model.Employee;
import com.accenture.employee.repo.EmployeeRepository;
import com.accenture.employee.service.EmployeeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

@Transactional
@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;
    public static List<Employee> employeeList = new ArrayList<>(Arrays.asList(

            new Employee("E1", "John", "SE", 9, 4500000, "Python", "n", "P2", "Bengaluru"),
            new Employee("E2", "Harry", "ASE", 12, 500000, "Java", "y", "P3", "Chennai"),
            new Employee("E3", "Potter", "Manager", 8, 9000000, "Big Data", "n", "P4", "Gurgaon"))
    );

    @Override
    public Employee addEmployee(Employee employee) {

        // employeeList.add(employee);
        empRepo.save(employee);
        return employee;
    }
    @Override
    public List<Employee> getAllEmployees()
    {

        return empRepo.findAll();
    }
    @Override
    public Employee getEmployee(String empID) {
        // Employee employee = employeeList.stream().filter(e -> empID.equals(e.getEmpID())).findFirst().get();
//        Employee employee = null;
//        for (Employee e : employeeList) {
//            if (e.getEmpID().equals(empID)) {
//                employee = e;
//                break;
//            }
//        }
        ;
        return empRepo.findById(empID).get();
    }
    @Override
    public Employee updateEmployee(Employee emp, String empID) {
        final Employee temp = new Employee();
        Employee employee1 = empRepo.findById(empID).get();
        System.out.println(new Gson().toJson(employee1));
        System.out.println(employee1.getEmpID());
                temp.setEmpID(empID);
                if (emp.getDesignation() != null) temp.setDesignation(emp.getDesignation());
                else temp.setDesignation(employee1.getDesignation());
                if (emp.getCareer_lvl() != 0) temp.setCareer_lvl(emp.getCareer_lvl());
                else temp.setCareer_lvl(employee1.getCareer_lvl());
                if (emp.getSalary() != 0) temp.setSalary(emp.getSalary());
                else temp.setSalary(employee1.getSalary());
                if (emp.getName() != null) temp.setName(emp.getName());
                else temp.setName(employee1.getName());
                if (emp.getPrimary_skill() != null) temp.setPrimary_skill(emp.getPrimary_skill());
                else temp.setPrimary_skill(employee1.getPrimary_skill());
                if (emp.getLocation() != null) temp.setLocation(emp.getLocation());
                else temp.setLocation(employee1.getLocation());
                if (emp.getProject_assigned() != null) temp.setProject_assigned(emp.getProject_assigned());
                else temp.setProject_assigned(employee1.getProject_assigned());
                if (emp.getSkill_proficiency() != null) temp.setSkill_proficiency(emp.getSkill_proficiency());
                else temp.setSkill_proficiency(employee1.getSkill_proficiency());
                empRepo.save(temp);
                return temp;
            }

    @Override
    public List<Employee> deleteEmployee(String empID) {
        // employeeList.removeIf(e -> (e.getEmpID().equals(empID)));

        // return employeeList;
        empRepo.deleteById(empID);
        return empRepo.findAll();
    }
}

