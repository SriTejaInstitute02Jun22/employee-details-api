package com.sriteja.api.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sriteja.api.model.EmployeeDetails;
import com.sriteja.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	private static final Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	  private EmployeeRepository employeeRepository;

	/**
	 * To insert the employee data in the table
	 */
	@Override
	public String insertEmployeeDetails(EmployeeDetails employeeDetails) {
		logger.info("Employee Details in Service Layer : " +employeeDetails);
		  employeeRepository.save(employeeDetails);
		 return "Updated records";
	}


	/**
	 * to get the details based on company
	 */
	@Override
	public String getEmployeeDetails(String empCompany) {
		logger.info("Details in service layer : " +empCompany);
		return employeeRepository.finfByEmployeeName(empCompany);
		
	}

	/**
	 * update the employee details based on company
	 */
	@Override
	public String updateEmployeeDetails(EmployeeDetails employeeDetails, String empCompany) {
		logger.info("Details in service layer : " +empCompany);
		EmployeeDetails employee = employeeRepository.findByEmployeeCompany(empCompany);
		if (Optional.ofNullable(employee).isPresent()) {
			employee.setEmpCompany(employee.getEmpCompany());
			employeeRepository.save(employee);
			return "updated done";
		}else {
		return "not updated";
	}
	}
}
