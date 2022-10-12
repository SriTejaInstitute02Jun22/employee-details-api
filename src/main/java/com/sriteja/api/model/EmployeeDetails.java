package com.sriteja.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeDetails {
	//attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeeMobile;
	
	public EmployeeDetails() {
		
	}
	public EmployeeDetails(int employeeId, String employeeName, String employeeEmail, String employeeMobile) {
		
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeMobile = employeeMobile;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeMobile() {
		return employeeMobile;
	}

	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + ", employeeMobile=" + employeeMobile + "]";
	}
	
	
	
	

}
