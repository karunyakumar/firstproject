package com.employee.operations.sampleapp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema = "APPSPPADM")
public class Employee {
	
	@SequenceGenerator(name = "EMPLOYEE_SEQ_GENERATOR", sequenceName = "APPSPPADM.EMPLOYEE_SEQ", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ_GENERATOR")
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="department")
	private String department;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, int salary, String department) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public Employee(int id, String name, int salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ "]";
	}
	
}
