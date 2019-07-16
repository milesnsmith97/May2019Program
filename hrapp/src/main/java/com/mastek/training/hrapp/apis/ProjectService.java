package com.mastek.training.hrapp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Project;
import com.mastek.training.hrapp.repositories.ProjectRepository;

@Component
@Scope("singleton")
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectService() {
		System.out.println("Project Service Created");
	}
	
	public Project registerOrUpdateProject(Project proj) {
		proj=projectRepository.save(proj);
		System.out.println("Project Registered" + proj);
		return proj;
	}
	
	
	public Project findByProjId(int projid) {
		try {
			return projectRepository.findById(projid).get();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public void deleteByProjId(int projid) {
		projectRepository.deleteById(projid);
	}

}
