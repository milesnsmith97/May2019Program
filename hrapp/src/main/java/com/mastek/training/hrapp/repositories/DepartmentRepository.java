package com.mastek.training.hrapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastek.training.hrapp.entities.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{

	List<Department> findByLocation(@Param("location")String location);
	
	// declare custom query method, with the same name as query
}
