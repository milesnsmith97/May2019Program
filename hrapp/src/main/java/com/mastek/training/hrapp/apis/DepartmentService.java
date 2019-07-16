package com.mastek.training.hrapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.repositories.DepartmentRepository;

@Component
@Scope("singleton")
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department registerOrUpdateDepartment(Department dpt) {
		dpt = departmentRepository.save(dpt);
		System.out.println("Department Registered " + dpt);
		return dpt;
	}

	public Object findByDeptno(int deptno) {
		try {
			return departmentRepository.findById(deptno).get();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteByDeptno(int deptno) {
		departmentRepository.deleteById(deptno);
		
	}

	public List<Department> fetchEmployeesByLocation(String location) {
		return departmentRepository.findByLocation(location);
	}

}
