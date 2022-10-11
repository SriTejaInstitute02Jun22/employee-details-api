package com.sriteja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sriteja.api.model.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails,Integer> {

	@Query(value=" select* from employee e where e.emp_company=:empCompany", nativeQuery=true) 
	String finfByEmployeeName(@Param("empCompany") String empCompany);

}


