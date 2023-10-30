package com.qsp.springboot_employee_pejm16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.springboot_employee_pejm16.dto.Employee;



public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	
	Employee findByEmail(String email);
	
	@Query("SELECT e FROM Employee e WHERE e.phone=?1")
	Employee empByPhone(long phone);

//   @Query("SELECT e FROM Employee e Where e.sal>=1")
	List<Employee> findEmployeesBySalGreaterThan(double sal);

}
