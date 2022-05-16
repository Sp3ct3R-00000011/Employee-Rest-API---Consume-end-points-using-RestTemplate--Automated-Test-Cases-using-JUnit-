package com.accenture.consume.employee.serviceImpl;

import com.accenture.consume.employee.model.Employee;
import com.accenture.consume.employee.service.implementation.EmployeeConsumeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class EmployeeConsumeServiceImplTest {

    @Autowired
    private EmployeeConsumeServiceImpl empConsumeServiceImpl;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getEmployeesTest() {
        List<Employee> list = empConsumeServiceImpl.get_employees();
        assertNotNull(list, "Reading Employee data!!!");
    }

    @Test
    public void getEmployeeByIDTest() {
        Employee emp = empConsumeServiceImpl.get_by_id("E2");
        assertEquals("E2", emp.getEmpID());
        System.out.println(emp.getEmpID());
    }

    @Test
    public void addEmployeeTest() {
        Employee emp1 = new Employee("E11", "Felix", "Manager", 7, 4500000, "Python", "n", "P2", "Bengaluru");
        Employee res = empConsumeServiceImpl.add_employee(emp1);
        System.out.println(res);
        assertNotNull(emp1, "creating the employee data!");
    }

    @Test
    public void updateEmployeesTest() {
        Employee temp = new Employee("E4", "Sam", "SE", 9, 7500000, "Java", "y", "P3", "Mumbai");
        Employee t = empConsumeServiceImpl.updateEmployee(temp, "E4");
        assertNotNull(t);
    }


    @Test
    public void deleteEmployeeTest() {
        ResponseEntity<String> temp = empConsumeServiceImpl.deleteEmployee("E11");
        assertNotNull(temp);

    }
}

