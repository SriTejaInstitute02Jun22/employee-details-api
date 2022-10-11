package com.sriteja.api.service;

import org.springframework.stereotype.Service;

import com.sriteja.api.model.EmployeeDetails;

@Service
public interface EmployeeService {

	public String insertEmployeeDetails(EmployeeDetails employeeDetails);

	public String getEmployeeDetails(String empCompany);

}
