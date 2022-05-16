package com.accenture.employee.controller;

import com.accenture.employee.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmployeeApplicationControllerTests {
    @Autowired
    private EmployeeController empcon;


    @Test
    public void contextLoads() {
    }

    @Test
    public void getEmployeesTest() {
        List<Employee> list = empcon.getAllEmployees();
        assertNotNull(list, "Reading Employee data!!!");
        System.out.println(list);
    }

    @Test
    public void getEmployeeTest() {
        Employee temp = empcon.getEmployee("E1");
        assertEquals("E1", temp.getEmpID());
        System.out.println(temp.getEmpID());
    }

    @Test
    public void getEmployeeTest_param() {
        Employee temp = empcon.getEmployee_param("E1");
        assertEquals("E1", temp.getEmpID());
        System.out.println(temp.getEmpID());
    }

    @Test
    public void createEmployeeTest() {
        Employee e = new Employee("E5", "John", "SE", 9, 4500000, "Python", "n", "P2", "Bengaluru");
        Employee res = empcon.addEmployee(e);
        System.out.println(res);
        assertNotNull(e, "creating the employee data!");
    }

    @Test
    public void UpdateEmployeeTest() {
        Employee temp = new Employee("E1", "Sam", "SE", 9, 7500000, "Java", "y", "P3", "Mumbai");
        empcon.updateEmployee(temp, "E1");
        System.out.println(temp.getEmpID());
        assertNotNull(temp);
    }

    @Test
    public void UpdateEmployeeTest_path() {
        Employee temp = new Employee("E1", "Nancy", "SSE", 10, 24500000, "Oracle", "n", "P5", "Gurgaon");
        empcon.updateEmployee_path(temp, "E1");
        System.out.println(temp.getEmpID());
        assertNotNull(temp);
    }

    @Test
    public void DeleteEmployeeTest() {
        List<Employee> temp = empcon.deleteEmployee("E5");
        assertNotNull(temp);
        temp.forEach((n) -> System.out.println(n.getEmpID()));
    }

    @Test
    public void DeleteEmployeeTest_param() {
        Employee e = new Employee("E6", "John", "SE", 9, 4500000, "Python", "n", "P2", "Bengaluru");
        Employee res = empcon.addEmployee(e);
        List<Employee> temp = empcon.deleteEmployee_param("E6");
        assertNotNull(temp);
        temp.forEach((n) -> System.out.println(n.getEmpID()));
    }
}

