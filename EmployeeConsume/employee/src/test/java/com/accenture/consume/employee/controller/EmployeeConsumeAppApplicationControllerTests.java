package com.accenture.consume.employee.controller;

import com.accenture.consume.employee.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class EmployeeConsumeAppApplicationControllerTests {

    @Autowired
    private EmployeeController empcon;


    @Test
    public void getEmployeesTest() {
        List<Employee> list = empcon.getemployees();
        assertNotNull(list, "Reading Employee data!!!");
    }

    @Test
    public void getEmployeeByIDTest() {
        Employee emp = empcon.get_by_id("E1");
        assertEquals("E1", emp.getEmpID());
        System.out.println(emp.getEmpID());
    }

    @Test
    public void addEmployeeTest() {
        Employee emp1 = new Employee("E9", "Felix", "Manager", 7, 4500000, "Python", "n", "P2", "Bengaluru");
        Employee res = empcon.add_employee(emp1);
        System.out.println(res);
        assertNotNull(emp1, "creating the employee data!");
    }

    @Test
    public void updateEmployeesTest() {
        Employee temp = new Employee("E1", "Jack", "SE", 9, 7500000, "Java", "y", "P3", "Mumbai");
        empcon.updateEmployee(temp, "E1");
        System.out.println(temp.getEmpID());
        assertNotNull(temp);
    }

    @Test
    public void updateEmployees_ExchangeTest() {
        Employee temp = new Employee("E1", "Sam", "SE", 9, 7500000, "Java", "y", "P3", "Mumbai");
        empcon.updateEmployee_ex(temp, "E1");
        assertNotNull(temp);
    }

    @Test
    public void deleteEmployeeTest() {
        String temp = empcon.deleteEmp("E3");
        assertNotNull(temp);

    }

    @Test
    public void deleteEmployee_ExchangeTest() {
        ResponseEntity<String> temp = empcon.deleteEmp_ex("E2");
        assertNotNull(temp);

    }
}
