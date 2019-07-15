package com.mastek.training.hrapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.repositories.EmployeeRepository;

//@Component Indicate to Spring to create an object of this class as a component
//@Scope: singleton: one object for application [default]
//		  prototype: one object for each usage
@Component
@Scope("singleton")
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//constructor
	public EmployeeService() {
		System.out.println("Employee Service Created");
	}
	
	
	public Employee registerOrUpdateEmployee(Employee emp) {
		emp = employeeRepository.save(emp);
		System.out.println("Employee Registered "+emp);
		return emp;
		
	}


	public Employee findByEmpno(int empno) {
		// fetches the Employee details from DB empno
		try {
			return employeeRepository.findById(empno).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Employee> fetchEmployeesBySalaryRange(
			double min, double max
			){
		return employeeRepository.findBySalary(min, max);
	}


	public void deleteByEmpno(int empno) {
		employeeRepository.deleteById(empno);
		
	}

}


















