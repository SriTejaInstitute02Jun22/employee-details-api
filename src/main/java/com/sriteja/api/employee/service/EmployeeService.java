package com.sriteja.api.employee.service;

import com.sriteja.api.employee.model.EmployeeDetails;

public interface EmployeeService {

	public String insertEmployeeDetails(EmployeeDetails employeeDetails);

	public EmployeeDetails getEmployeeDetailsByOnEmployeeId(int employeeId);

	public String updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(EmployeeDetails employeeDetails,
			int employeeId, String employeeEmail);

	public String deleteEmployeeDetailsBasedOnEmployeeMobile(String employeeMobile);
}