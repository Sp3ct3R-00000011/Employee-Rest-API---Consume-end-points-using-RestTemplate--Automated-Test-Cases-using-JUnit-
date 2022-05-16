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
    public void contextLoads() {
    }

    @Test
    public void getEmployeesTest() {
        List<Employee> list = empcon.get_emp();
        assertNotNull(list, "Reading Employee data!!!");
    }

    @Test
    public void getEmployeeByIDTest() {
        Employee emp = empcon.get_emp_by_id("E9");
        assertEquals("E9", emp.getEmpID());
        System.out.println(emp.getEmpID());
    }

    @Test
    public void addEmployeeTest() {
        Employee emp1 = new Employee("E9", "Felix", "Manager", 7, 4500000, "Python", "n", "P2", "Bengaluru");
        Employee res = empcon.add_emp(emp1);
        System.out.println(res);
        assertNotNull(emp1, "creating the employee data!");
    }

    @Test
    public void updateEmployeesTest() {
        Employee temp = new Employee("E5", "Sam", "SE", 9, 7500000, "Java", "y", "P3", "Mumbai");
        Employee t = empcon.updateEmp(temp, "E5");
        assertNotNull(t);
    }


    @Test
    public void deleteEmployeeTest() {
        ResponseEntity<String> temp = empcon.deleteEmp("E9");
        assertNotNull(temp);

    }
}
