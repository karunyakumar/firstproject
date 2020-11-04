package com.employee.operations.sampleapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.operations.sampleapp.Entity.Employee;
import com.employee.operations.sampleapp.repository.EmployeeRepository;


@Component
public class EmployeeService {
	
	
	@Autowired 
	private EmployeeRepository empRepo;
    public   List<Employee> findEmployees(){
    	
    	return empRepo.findAll();
    }
    
    public List<Employee> findTopEmpDetails(int top){
    	
    	return empRepo.getTopDetails(top);
    }
    
    public List<Employee> findReqDetails(int top){
    	   
    	int limit= empRepo.getTheLimit();
    	return empRepo.getReqDetails(limit, top);
    }
    
    public Employee findWithId(int id) {
    	
    	Employee theEmployee= empRepo.findOne(id);
    	if (theEmployee == null) {
			throw new RuntimeException("Couldn't find the given Id: " + id);
		} else {
			return theEmployee;
		}
    }
    
    public Employee addEmpService(Employee theEmployee) {
		try {
			System.out.println(theEmployee.toString());
			empRepo.save(theEmployee);
			return theEmployee;
		} catch (Exception e) {
			System.out.println("Exception occurs due to" + e.getMessage());
		}
		return theEmployee;
	}
    
    public Employee updempService(Employee theEmployee) {
		empRepo.saveAndFlush(theEmployee);
		return theEmployee;
	}
    
    public String deleteEmpService( int theId) {
		Employee theEmployee = empRepo.findOne(theId);
		if (theEmployee == null) {
			throw new RuntimeException("Couldn't find the given Id: " + theId);
		}
		empRepo.delete(theId);
		return "Deleted the given Id: " + theId;
	}
}






