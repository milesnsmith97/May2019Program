package com.mastek.training.hrapp.repositories;


import org.springframework.data.repository.CrudRepository;

import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;

public interface ProjectRepository extends CrudRepository<Project,Integer > {


}
