package com.qsp.springboot_employee_pejm16.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.qsp.springboot_employee_pejm16.dto.Employee;
import com.qsp.springboot_employee_pejm16.repository.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee findEmployeeById(int id) {
//		return employeeRepo.findById(id).get();

		// TO Avoid No SuchException
		Optional<Employee> optional = employeeRepo.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	public Employee deleteEmployee(int id) {

		Optional<Employee> optional = employeeRepo.findById(id);

		if (optional.isEmpty()) {
			return null;

		} else {

			employeeRepo.deleteById(id);
			return optional.get();

			// Other Way

//			 Employee employee = optional.get();
//			 employeeRepo.delete(employee);
//			 return employee;
		}

	}

	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> optional = employeeRepo.findById(id);

		if (optional.isPresent()) {
			employee.setId(id);
			return employeeRepo.save(employee);
		}
		return null;
	}

	public Employee findEmployeeByEmail(String email) {
		
		return employeeRepo.findByEmail(email);
	}

	public Employee empByPhone(long phone) {
		
		return employeeRepo.empByPhone(phone);
	}

	public List<Employee> findEmployeesBySalGreaterThan(double sal) {
		
		return employeeRepo.findEmployeesBySalGreaterThan(sal);
	}
	
	
	
	

}
