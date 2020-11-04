package com.employee.operations.sampleapp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.operations.sampleapp.Entity.Employee;
import com.employee.operations.sampleapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService empService;

	@RequestMapping(path = "/welcome", produces = "application/json")
	public String welcome() {
		return "Welcome to Spring Boot";
	}

	@GetMapping(path = "/employees", produces = "application/json")
	public List<Employee> findAll() {
		return  empService.findEmployees();
	}

	@GetMapping(path = "/getTopEmpDetails/{top}", produces = "application/json")
	public List<Employee> getTopEmpDetails(@PathVariable int top) {
		return empService.findTopEmpDetails(top);
	}
     
	@GetMapping(path = "/getReqEmpDetails/{top}", produces = "application/json")
	public List<Employee> getReqEmpDetails(@PathVariable int top) {
		return empService.findReqDetails(top);
	}
	
	@GetMapping(path = "/empWithId/{theId}", produces = "application/json")
	public Employee findWithId(@PathVariable int theId) {
		return empService.findWithId(theId);
	}

	@PostMapping("/addemp")
	public Employee addEmp(@RequestBody Employee theEmployee) {
		return empService.addEmpService(theEmployee);
	}

	@PutMapping(path = "/updateemp", produces = "application/json")
	public Employee updemp(@RequestBody Employee theEmployee) {
		return empService.updempService(theEmployee);
	}

	@DeleteMapping(path = "/deleteemp/{theId}", produces = "application/json")
	public String deleteEmp(@PathVariable int theId) {
		return empService.deleteEmpService(theId);
	}
}
