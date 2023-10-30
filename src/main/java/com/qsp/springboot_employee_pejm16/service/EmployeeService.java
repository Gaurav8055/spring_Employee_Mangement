package com.qsp.springboot_employee_pejm16.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.qsp.springboot_employee_pejm16.dao.EmployeeDao;
import com.qsp.springboot_employee_pejm16.dto.Employee;
import com.qsp.springboot_employee_pejm16.util.ResponseStructure;

@Service
public class EmployeeService {
	
    @Autowired
	private EmployeeDao dao ;
    
    ResponseStructure<Employee> structure = new ResponseStructure<>();
	
	public ResponseStructure<Employee> saveEmployee(Employee employee)
	{
		double salary = employee.getSal();
		
		if(salary <= 10000)
		{
			employee.setGrade('A');
		}
		else if(salary > 10000 && salary <= 20000)
		{
			employee.setGrade('B');
		}
		
		else if(salary > 20000 && salary <= 40000)
		{
			employee.setGrade('C');
		}
		else
		{
			employee.setGrade('D');
		}
		
		
		structure.setMessage("Save Sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmployee(employee));
		return structure;
	}
	
	
	public ResponseStructure<Employee> findEmployeeById( int id) {
		Employee employee =  dao.findEmployeeById(id);
		if(employee != null)
		{
			structure.setMessage("Found Sucessfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return structure;
		}
		else
		{
			structure.setMessage("Not Found Sucessfully");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return structure;
		}
		
	}
	
	public ResponseStructure<List<Employee>> findAll() {
		
		List<Employee> list = dao.findAll();
		
		 ResponseStructure < List<Employee>> structure = new ResponseStructure<>();
		if(list.isEmpty())
		{
			structure.setMessage("Data Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return structure;
		}
		else
		{
			structure.setMessage("All Data Found Sucessfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return structure;
		}
//		return dao.findAll();
	}
	
	public Employee deleteEmployee( int id) {
		return dao.deleteEmployee(id);
	}
	
	public Employee updateEmployee( int id,  Employee employee) 
	{
          double salary = employee.getSal();
		
		if(salary <= 10000)
		{
			employee.setGrade('A');
		}
		else if(salary > 10000 && salary <= 20000)
		{
			employee.setGrade('B');
		}
		
		else if(salary > 20000 && salary <= 40000)
		{
			employee.setGrade('C');
		}
		else
		{
			employee.setGrade('D');
		}
		return dao.updateEmployee(id, employee);
	}


	public Employee updatePhone(int id, long phone) {
	Employee employee = dao.findEmployeeById(id);
	employee.setPhone(phone);
	
		return dao.updateEmployee(id, employee);
	}


	public Employee updateEmail(int id, String email) {
	Employee employee = dao.findEmployeeById(id);
	employee.setEmail(email);
		return dao.updateEmployee(id, employee);
	}


	public Employee updateSalary(int id, double sal) {
		Employee employee = dao.findEmployeeById(id);
		employee.setSal(sal);
		
		return updateEmployee(id, employee);
	}


	public Employee findEmployeeByEmail(String email) {
		
		return dao.findEmployeeByEmail(email);
	}


	public Employee empByPhone(long phone) {
		
		return dao.empByPhone(phone);
	}


	public List<Employee> findEmployeesBySalGreaterThan(double sal) {
		
		return dao.findEmployeesBySalGreaterThan(sal);
	}
	
	
	

}
