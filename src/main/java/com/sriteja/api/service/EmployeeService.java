package com.sriteja.api.service;

import com.sriteja.api.model.EmployeeDetails;

public interface EmployeeService {

	public String insertEmployeeDetails(EmployeeDetails employeeDetails);

	public EmployeeDetails getEmployeeDetailsByEmployeeId(String employeeId);

	public String updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(EmployeeDetails employeeDetails,
			int employeeId, String employeeEmail);

	public String deleteEmployeedetailsBasedOnEmployeeMobile(String employeeMobile);

	


	


}
