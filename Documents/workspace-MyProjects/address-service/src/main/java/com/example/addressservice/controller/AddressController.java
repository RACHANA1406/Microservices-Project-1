package com.example.addressservice.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.addressservice.model.Address;
import com.example.addressservice.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	public AddressService addressService;
	
	@PostMapping("/address")
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddresses(){
		return addressService.getAllAddresses();
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddress(@PathVariable("id") int id){
		return addressService.getAddress(id);
	}
	
	@GetMapping("/employees/{employeeId}/address")
	public Address getAddressByEmployeeId(@PathVariable("employeeId") int employeeId) {
		return addressService.getAddressByEmployeeId(employeeId);
	}
}
