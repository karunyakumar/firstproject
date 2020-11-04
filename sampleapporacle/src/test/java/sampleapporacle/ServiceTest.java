package sampleapporacle;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.operations.sampleapp.Entity.Employee;
import com.employee.operations.sampleapp.repository.EmployeeRepository;
import com.employee.operations.sampleapp.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
public class ServiceTest {
    
	@InjectMocks
	private EmployeeService ec;
	
	@Mock
	private EmployeeRepository empRepo;
	
	@Before
	public void setUp() {
		
		try {
			System.out.println("Initialization");
			MockitoAnnotations.initMocks(this);
		} catch (Exception e) {
			System.out.println("Exception");
			//e.printStackTrace();
		}
	}
	
	@Test
	public void  mockTestEx() {
		when(empRepo.findAll()).thenReturn(Stream.of(new Employee(1,"kips",9000,"IT"),
				 new Employee(2,"karunya",8000,"CA")).collect(Collectors.toList()));
		assertEquals(2, ec.findEmployees().size());
	}
	
	@Test
	public void findWithIdTest() {
		
		 Employee emp =  new Employee(1,"kips",8000,"IT");
		when(empRepo.findOne(2)).thenReturn(emp);
		
		assertEquals(emp, ec.findWithId(2));
	}
	
	/*@Test
	public void welcomeTest() {
		String str="Welcome to sampleapp";
		when(ec.welcome()).thenReturn(str);
		assertEquals(str, ec.welcome());
	}*/
	
	@Test
	public void topEmpDetailsTest() {
		when(empRepo.getTopDetails(2)).thenReturn(Stream.of(new Employee(1,"kips",9000,"IT"),
				 new Employee(2,"karunya",8000,"CA")).collect(Collectors.toList()));
		assertEquals(2, ec.findTopEmpDetails(2).size());
	}
	
	@Test
	public void findReqDetailsTest() {
		when(empRepo.getTheLimit()).thenReturn(20);
		when(empRepo.getReqDetails(20,2)).thenReturn(Stream.of(new Employee(1,"kips",9000,"IT"),
				 new Employee(2,"karunya",8000,"CA")).collect(Collectors.toList()));
		assertEquals(2, ec.findReqDetails(2).size());
	}
	
	@Test
	public void addEmpTest() {
		Employee emp= new Employee(3,"kips",8000,"IT");
		ec.addEmpService(emp);
		verify(empRepo).save(emp);
	}
    
	@Test
	public void updempTest() {
		Employee emp =new Employee(3,"kips",8000,"IT");
		ec.updempService(emp);
		verify(empRepo).saveAndFlush(emp);
	}
	
	@Test
	public void deletetest() {
		Employee emp = new Employee(3,"kips",8000,"IT");
		when(empRepo.findOne(1)).thenReturn(emp);
		ec.deleteEmpService(1);
		verify(empRepo).delete(1);
	}
} 




