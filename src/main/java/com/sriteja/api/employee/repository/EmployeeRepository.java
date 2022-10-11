package com.sriteja.api.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sriteja.api.employee.model.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {

	// JPQL(Java Persistance Query Language)
	@Query(value = "select * from employee c where c.employee_id = :employeeId", nativeQuery = true)
	EmployeeDetails findByEmployeeId(@Param("employeeId") String employeeId);

	@Query(value = "select * from employee c where c.employee_id=:employeeId and c.employee_email=:employeeEmail", nativeQuery = true)
	EmployeeDetails findByEmployeeIdAndEmployeeEmail(@Param("employeeId") int employeeId,
			@Param("employeeEmail") String employeeEmail);

	@Modifying
	@Query(value = "delete from employee where employee_mobile=?1", nativeQuery = true)
	void deleteByEmployeeMobile(String employeeMobile);

}
