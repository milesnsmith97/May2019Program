package com.mastek.training.hrapp.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //one copy for each test
@Entity // declares as an entity
@Table(name="JPA_PROJECT")// declaring the table name for the class
public class Project implements Serializable {

		
@Value("-1")
private int projectId;
@Value("Default Name")
private String name;
@Value("Default Customer Name")
private String customerName;
			
			
	public Project() {
		System.out.println("Project Created");
	}
	
	private Set<Employee> team=new HashSet<>();
	
	@Id //declare the property as Primary Key
	@Column(name="project_id")//declare the column name
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public int getProjectId() {
	return projectId;
	}

			
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Column(name="project_name", nullable= false, length=45)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Override
	public String toString() {
		return "Project [getProjectId()=" + getProjectId() + ", getName()=" + getName() + ", getCustomerName()="
				+ getCustomerName() + "]";
	}


	//mappedBy: check the configurations for Many to many association
	//in Employee class getAssignments() method
	@ManyToMany(mappedBy="assignments")
	public Set<Employee> getTeam() {
		return team;
	}


	public void setTeam(Set<Employee> team) {
		this.team = team;
	}
			
			
			
			
			
			



}
