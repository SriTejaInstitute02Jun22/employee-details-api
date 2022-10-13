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
	  private EmployeeRepository employeeRepository;//dependency injection

	/**
	 * To insert the employee data in the table
	 * implementing insertEmployeeDetails()
	 */
	@Override
	public String insertEmployeeDetails(EmployeeDetails employeeDetails) {
		logger.info("Employee Details in Service Layer : " +employeeDetails);
		  employeeRepository.save(employeeDetails);
		 return "Updated records";
	}


	/**
	 * to get the details based on company
	 * implementing getEmployeeDetails()
	 */
	@Override
	public String getEmployeeDetails(String empCompany) {
		logger.info("Details in service layer : " +empCompany);
		return employeeRepository.findByEmployeeName(empCompany);
		
	}

	/**
	 * update the employee details based on company
	 * implementing the updateEmployeeDetails()
	 */
	@Override
	public String updateEmployeeDetails(EmployeeDetails employeeDetails, String empCompany) {
		logger.info("Employee Details : " +employeeDetails);
		logger.info("Details in service layer : " +empCompany);
		String response=null;
		EmployeeDetails employee = employeeRepository.findByEmployeeCompany(empCompany);
		if (Optional.ofNullable(employee).isPresent()) {
			employee.setEmpName(employeeDetails.getEmpName());
			employee.setEmpDesignation(employeeDetails.getEmpDesignation());
			employeeRepository.save(employee);
			
			return response = "Updated employee details base on" +empCompany +"is done";
		}else {
			return response = "Not updated";
		}
	}

	@Override
	public String deleteEmployeeDetails(String empDesignation) {
		logger.info("Employee Details in Service layer : "+empDesignation);
		return employeeRepository.findByEmployeeDesignation(empDesignation);
	}
}
