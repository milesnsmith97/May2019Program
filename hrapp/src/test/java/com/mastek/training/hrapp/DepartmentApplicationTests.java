package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.DepartmentService;
import com.mastek.training.hrapp.entities.Department;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentApplicationTests {
	
	@Autowired
	DepartmentService dptService;
	
	@Autowired
	Department dpt;
	
	@Test
	public void addDepartmentUsingService() {
		dpt.setDeptno(1);
		dpt.setLocation("London");
		dpt.setName("New Department");
		dpt = dptService.registerOrUpdateDepartment(dpt);
		assertNotNull(dpt);
	}
	
	@Test
	public void findByDeptnoUsingService() {
		int deptno = 25;
		assertNotNull(dptService.findByDeptno(deptno));
	}
	
	@Test
	public void deleteByDeptnoUsingService() {
		int deptno = 26;
		dptService.deleteByDeptno(deptno);
		assertNull(dptService.findByDeptno(deptno));
	}
	
	@Test
	public void contextLoads() {
		System.out.println("System Test Executed");
	}
	
	@Test
	public void checkFetchByLocation() {
		List<Department> depts = dptService.fetchEmployeesByLocation("Leeds");
		for (Department department : depts) {
			System.out.println(department);
		}
		
		assertEquals(depts.size(),4);
	}
	
	
	
	
	
	
}
