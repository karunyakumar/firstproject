package com.employee.operations.sampleapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.operations.sampleapp.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	  
	  @Query(value="select * from(select * from employee  order by salary desc) where ROWNUM<=?1 ",nativeQuery=true)
	  List<Employee> getTopDetails(int top);
	  
	  @Query(value="select max(average) as limit from(select avg(salary) as average from employee group by department)",nativeQuery=true)
	  int getTheLimit();
	  
	  @Query(value="select * from(select * from employee where salary>?1)where rownum<=?2",nativeQuery=true)
	  List<Employee> getReqDetails(int limit,int top);
	
}
