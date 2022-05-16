package com.accenture.employee.service;

import com.accenture.employee.model.Employee;
import com.accenture.employee.service.implementation.EmployeeServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeApplicationServiceTests {
	@Autowired
	private EmployeeServiceImplementation employeeServiceImpl;


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
		employeeServiceImpl.addEmployee(temp);
		assertNotNull(temp, "creating the employee data!");
	}
	@Test
	public void getEmployeesServiceTest(){
		List <Employee> list = employeeServiceImpl.getAllEmployees();
		assertNotNull(list, "Reading Employee data!!!");
	}
	@Test
	public void getEmployeeServiceTest(){
		Employee temp = employeeServiceImpl.getEmployee("E1");
		assertEquals("E1", temp.getEmpID());
		System.out.println(temp.getEmpID());
	}

	@Test
	public void getEmployeeServiceNotInListTest(){
		Employee temp = employeeServiceImpl.getEmployee("E1");
		assertNotNull(temp);
		//System.out.println(temp.getEmpID());
	}

	@Test
	public void UpdateEmployeeServiceTest(){
		Employee temp = new Employee("E1","Sid","SE", 9, 7500000, "Java", "y", "P3","Mumbai");
		System.out.println(temp.getEmpID());
		Employee t = employeeServiceImpl.updateEmployee(temp, "E1");
		assertNotNull(t);

	}

	@Test
	public void UpdateEmployeeServiceTestIfNull(){
		Employee temp = new Employee();
		Employee t = employeeServiceImpl.updateEmployee(temp, "E1");
		System.out.println(t.getEmpID());
		assertNotNull(t);

	}

	@Test
	public void DeleteEmployeeServiceTest() {
		List<Employee> temp = employeeServiceImpl.deleteEmployee("E11");
		assertNotNull(temp);
		temp.forEach((n) -> System.out.println(n.getEmpID()));
	}
}

