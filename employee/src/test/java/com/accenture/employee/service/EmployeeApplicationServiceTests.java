package com.accenture.employee.service;

import com.accenture.employee.model.Employee;
import com.accenture.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmployeeApplicationServiceTests {
	@Autowired
	private EmployeeService empService;


	@Test
	public void contextLoads() {
	}

	@Test
	public void createEmployeeServiceTest() {
		Employee temp = new Employee();
		temp.setEmpID("E11");
		temp.setName("Nancy");
		temp.setDesignation("SSE");
		temp.setCareer_lvl(8);
		temp.setSalary(3500000);
		temp.setPrimary_skill("Dot Net");
		temp.setProject_assigned("y");
		temp.setLocation("Pune");
		temp.setSkill_proficiency("P2");
		empService.addEmployee(temp);
		assertNotNull(temp, "creating the employee data!");
	}
	@Test
	public void getEmployeesServiceTest(){
		List <Employee> list = empService.getAllEmployees();
		assertNotNull(list, "Reading Employee data!!!");
	}
	@Test
	public void getEmployeeServiceTest(){
		Employee temp = empService.getEmployee("E2");
		assertEquals("E2", temp.getEmpID());
		System.out.println(temp.getEmpID());
	}

	@Test
	public void UpdateEmployeeServiceTest(){
		Employee temp = new Employee("E1","Sid","SE", 9, 7500000, "Java", "y", "P3","Mumbai");
		System.out.println(temp.getEmpID());
		assertNotNull(temp);

	}

	@Test
	public void DeleteEmployeeServiceTest() {
		List<Employee> temp = empService.deleteEmployee("E3");
		assertNotNull(temp);
		temp.forEach((n) -> System.out.println(n.getEmpID()));
	}
}

