package com.sprk.emp_management;

import java.sql.Timestamp;

public class Employee {

	// Fields
	private int empId;
	private String name;
	private String email;
	private double salary;
	private Timestamp doj;

	// Constructors
	public Employee() {
		super();
	}

	public Employee(int empId, String name, String email, double salary, Timestamp doj) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.doj = doj;
	}

	public Employee(String name, String email, double salary, Timestamp doj) {
		super();
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.doj = doj;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Timestamp getDoj() {
		return doj;
	}

	public void setDoj(Timestamp doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", salary=" + salary + ", doj="
				+ doj + "]";
	}

}
