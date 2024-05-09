package com.example.addressservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "city")
	private String city;
	@Column(name = "pincode")
	private Long pincode;
	@Column(name="employee_id")
	private Integer employeeId;

	public Address() {}

	public Address(Integer id, String city, Long pincode, Integer employeeId) {
		this.id = id;
		this.city = city;
		this.pincode = pincode;
		this.employeeId=employeeId;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
