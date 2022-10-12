package com.sriteja.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	//attributes
	private int empId; //primary key
	
	private String empName;
	private String empCompany;
	private String empDesignation;
	private String empMobile;
	private int empSalary;
	private String empDepartment;
	
	//Non-Parameterized Constructor
	public EmployeeDetails() {
	}

	//Parameterized Constructor
	public EmployeeDetails(int empId, String empName, String empCompany, String empDesignation, String empMobile,
			int empSalary, String empDepartment) {
		this.empId = empId;
		this.empName = empName;
		this.empCompany = empCompany;
		this.empDesignation = empDesignation;
		this.empMobile = empMobile;
		this.empSalary = empSalary;
		this.empDepartment = empDepartment;
	}
	
	//Setter and Getter methods
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCompany() {
		return empCompany;
	}

	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	//toString() method
	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", empName=" + empName + ", empCompany=" + empCompany
				+ ", empDesignation=" + empDesignation + ", empMobile=" + empMobile + ", empSalary=" + empSalary
				+ ", empDepartment=" + empDepartment + "]";
	}
	
}
