package com.example.employeeservice.feignclient;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.employeeservice.model.Address;

//End point to be called by FeignClient
//http://address-service/address/{employeeId}

@FeignClient(name="address-service")
public interface AddressFeignClient {
	
	@GetMapping("/employees/{employeeId}/address")
	public Address getAddressByEmployeeId(@PathVariable("employeeId") int employeeId);
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddresses();
	
	@PostMapping("/address")
	public Address addAddress(@RequestBody Address address);
}
