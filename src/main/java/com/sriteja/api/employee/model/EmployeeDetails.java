package com.sriteja.api.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is entity class, to create the employee details into the databases.
 */
@Entity
@Table(name = "employee")
public class EmployeeDetails {

	// attribute
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String employeeName;
	private String employeeMobile;
	private String employeeEmail;
	private String employeeDept;
	private double employeeSalary;
	private String employeeJoiningDate;
	private String employeeDeign;

// non parameterized constructor
	public EmployeeDetails() {
	}

//parameterized constructor
	public EmployeeDetails(int employeeId, String employeeName, String employeeMobile, String employeeEmail,
			String employeeDept, double employeeSalary, String employeeJoiningDate, String employeeDeign) {

		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeMobile = employeeMobile;
		this.employeeEmail = employeeEmail;
		this.employeeDept = employeeDept;
		this.employeeSalary = employeeSalary;
		this.employeeJoiningDate = employeeJoiningDate;
		this.employeeDeign = employeeDeign;
	}

//To generate the Getters and Setters Method
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

	public String getEmployeeMobile() {
		return employeeMobile;
	}

	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeDept() {
		return employeeDept;
	}

	public void setEmployeeDept(String employeeDept) {
		this.employeeDept = employeeDept;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeJoiningDate() {
		return employeeJoiningDate;
	}

	public void setEmployeeJoiningDate(String employeeJoiningDate) {
		this.employeeJoiningDate = employeeJoiningDate;
	}

	public String getEmployeeDeign() {
		return employeeDeign;
	}

	public void setEmployeeDeign(String employeeDeign) {
		this.employeeDeign = employeeDeign;
	}

//To Generate The toString Method
	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeMobile="
				+ employeeMobile + ", employeeDept=" + employeeDept + ", employeeSalary=" + employeeSalary
				+ ", employeeJoiningDate=" + employeeJoiningDate + ", employeeDeign=" + employeeDeign + "]";
	}

}
