package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
public class Employees {
	@Id
	@NotNull
	@NotEmpty
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeeExperience;
	
	
	public Employees() {
		
	}
	
	public Employees(String employeeId, String employeeName, String employeeEmail, String employeeExperience) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeExperience = employeeExperience;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeExperience() {
		return employeeExperience;
	}
	public void setEmployeeExperience(String employeeExperience) {
		this.employeeExperience = employeeExperience;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + ", employeeExperience=" + employeeExperience + "]";
	}
	
}
