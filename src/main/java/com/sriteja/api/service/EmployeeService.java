package com.sriteja.api.service;



import com.sriteja.api.model.EmployeeDetails;

public interface EmployeeService {
	//post,get,put,delete methods creation in interface(service)

	public String insertEmployeeDetails(EmployeeDetails employeeDetails);

	public EmployeeDetails getEmployeeDetailsByEmployeeId(int employeeId);

	public String updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(EmployeeDetails employeeDetails,
			int employeeId, String employeeEmail);

	public String deleteEmployeeDataBasedOnEmployeeMobile(String employeeMobile);

	

}
