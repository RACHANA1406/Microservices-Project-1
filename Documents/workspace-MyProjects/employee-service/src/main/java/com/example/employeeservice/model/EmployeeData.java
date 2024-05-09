package com.example.employeeservice.model;

public class EmployeeData {
	
	private String name;
	
	private Integer age;
	
	private AddressData addressData;
	
	public EmployeeData() {

	}
	
	public EmployeeData(String name, Integer age, AddressData addressData) {
		this.name = name;
		this.age = age;
		this.addressData=addressData;
	}
	
	public AddressData getAddressData() {
		return addressData;
	}

	public void setAddressData(AddressData addressData) {
		this.addressData = addressData;
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
