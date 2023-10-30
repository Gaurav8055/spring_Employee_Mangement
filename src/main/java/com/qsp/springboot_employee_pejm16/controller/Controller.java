package com.qsp.springboot_employee_pejm16.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_employee_pejm16.dto.Employee;
import com.qsp.springboot_employee_pejm16.service.EmployeeService;
import com.qsp.springboot_employee_pejm16.util.ResponseStructure;

@RestController
public class Controller {

	
	
	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);

	}

	@GetMapping("/find")
	public ResponseStructure<Employee> findEmployeeById(@RequestParam int id) {
		return service.findEmployeeById(id);
	}

	@GetMapping("/findall")
	public ResponseStructure<List<Employee>> findAll() {
		return service.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestParam int id, @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}
	
	@PatchMapping("/updatePhone")
	public Employee updatePhone(@RequestParam int id , @RequestParam long phone) 
	{
		return service.updatePhone( id, phone);
	}
	
	@PatchMapping("/updateEmail")
	public Employee updateEmail( @RequestParam int id , @RequestParam String email)
	{
	   return service.updateEmail(id , email);
	}
	
	@PatchMapping("/updateSal")
	public Employee updataeSalary(@RequestParam int id ,@RequestParam double sal)
	{
		return service.updateSalary(id,sal);
	}
	
	@GetMapping("/findByEmail")
	public Employee findEmployeeByEmail(@RequestParam String email)
	{
	   return service.findEmployeeByEmail(email);
	}
	
	@GetMapping("/findByPhone/{phone}")
	public Employee empByPhone(@PathVariable long phone)
{
	return service.empByPhone(phone);
}
	
	@GetMapping("/findBySalGreaterThan")
	public List<Employee> findEmployeesBySalGreaterThan(@RequestParam double sal)
	{
		return service.findEmployeesBySalGreaterThan(sal);
	}

}
