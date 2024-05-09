package com.example.employeeservice.model;

public class AddressData {
	
	private String city;
	
	private Long pincode;
	
	public AddressData() {}

	public AddressData(String city, Long pincode) {
		this.city = city;
		this.pincode = pincode;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}	
}
