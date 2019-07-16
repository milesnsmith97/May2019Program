package com.mastek.training.hrapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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


	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + "]";
	}
	
}
