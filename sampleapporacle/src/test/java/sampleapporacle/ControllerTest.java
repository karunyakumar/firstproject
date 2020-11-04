package sampleapporacle;


import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.employee.operations.sampleapp.SampleappApplication;
import com.employee.operations.sampleapp.Entity.Employee;
import com.employee.operations.sampleapp.restcontroller.EmployeeRestController;
import com.employee.operations.sampleapp.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK,classes = SampleappApplication.class)
public class ControllerTest {
   
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private EmployeeService employeeService;
	
	@InjectMocks 
	private EmployeeRestController employeeController;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

	}
	
	@Test
	public void testAddEmployee() throws Exception{
		Employee empl= new Employee(2,"karunya",9000,"CA");
		//System.out.println("passed");
		when(employeeService.addEmpService(any(Employee.class))).thenReturn(empl);
		//System.out.println("passed");
		
		ObjectMapper om= new ObjectMapper();
		String json= om.writeValueAsString(empl);
		mockMvc.perform(post("/api/addemp")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
		
		//System.out.println("passed");
	}
	
	@Test
	public void testGetEmployee() throws Exception {
		Employee emp= new Employee(1,"kips",9000,"IT");
		Employee emp1= new Employee(2,"karunya",9000,"CA");
		List<Employee> list= new ArrayList<Employee>();
		list.add(emp);
		list.add(emp1);
		
		when(employeeService.findEmployees()).thenReturn(list);
		
		mockMvc.perform(get("/api/employees")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
	}
	
	@Test
	public void testGetTopEmp() throws Exception {
		Employee emp= new Employee(1,"kips",9000,"IT");
		Employee emp1= new Employee(2,"karunya",9000,"CA");
		List<Employee> list= new ArrayList<Employee>();
		list.add(emp);
		list.add(emp1);
		
		String top="2";
		when(employeeService.findTopEmpDetails(anyInt())).thenReturn(list);
		
		mockMvc.perform(get("/api/getTopEmpDetails/{top}",top)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void testGetReqEmp() throws Exception {
		Employee emp= new Employee(1,"kips",9000,"IT");
		Employee emp1= new Employee(2,"karunya",9000,"CA");
		List<Employee> list= new ArrayList<Employee>();
		list.add(emp);
		list.add(emp1);
		
		String top="2";
		when(employeeService.findReqDetails(Matchers.anyInt())).thenReturn(list);
		
		mockMvc.perform(get("/api/getReqEmpDetails/{top}",top)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void testGetWithId() throws Exception {
		 
		String id="3";
		Employee emp= new Employee(2,"kips",800,"It");
		
		when(employeeService.findWithId(anyInt())).thenReturn(emp);
		
		mockMvc.perform(get("/api/empWithId/{theId}",id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void testPutEmp() throws Exception {
		Employee emp= new Employee(2,"kips",800,"It");
		ObjectMapper om= new ObjectMapper();
		when(employeeService.updempService(any(Employee.class))).thenReturn(emp);
		
		String json= om.writeValueAsString(emp);
		mockMvc.perform(put("/api/updateemp")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("kips"))
				.andReturn();
	}
	
	@Test
	public void testDelEmp() throws Exception {
		String id="3";
		
		when(employeeService.deleteEmpService(anyInt())).thenReturn("delete Successfull"+id);
		
		mockMvc.perform(delete("/api/deleteemp/{theId}",id)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
}	




