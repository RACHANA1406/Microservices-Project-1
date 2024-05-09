package com.example.employeeservice.model;

public class EmployeeResponse {
	
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private Address address;
	
	public EmployeeResponse() {}
	
	public EmployeeResponse(Integer id, String name, Integer age, Address address) {
		this.id=id;
		this.name = name;
		this.age = age;
		this.address=address;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
