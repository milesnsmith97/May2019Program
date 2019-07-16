package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="JPA_DEPARTMENT")

@NamedQueries({
	@NamedQuery(name="Department.findByLocation",
			query="select d from Department d where d.location = :location")
})
public class Department implements Serializable {
	@Value("-1")
	private int deptno;
	
	@Value("Defualt Department")
	private String name;
	
	@Value("Default Location")
	private String location;
	
	public Department() {
		System.out.println("Department Created");
	}
	
	// One department has many Employees
	
		//@OneToMany: used on the get method of set to configure association
		//fetch=Lazy: delay the initialisation until method getMembers() is called
		//using additional select query.
		//EAGER: Initialise the collection on entity find Post load event
		//cascade= All the Entity operation done on Department would be performed on each associated employee object
		//ALL:[Persist,Merge,Delete,Refresh]
		
	
	private Set<Employee> members = new HashSet<>();

	
	@Id // declare the property as primary key
	@Column(name="department_number") // declare the name of the column
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto-numbering primary key
	public int getDeptno() {
		return deptno;
	}
	
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	@Column(name="department_name",nullable=false,length=45)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) { // JPA will default configurations
		this.location = location;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="currentDepartment")
	public Set<Employee> getMembers() {
		return members;
	}

	public void setMembers(Set<Employee> members) {
		this.members = members;
	}


	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + "]";
	}
	
}
