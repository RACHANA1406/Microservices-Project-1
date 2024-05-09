package com.example.addressservice.service;
import java.util.List;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.addressservice.model.Address;
import com.example.addressservice.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	Environment environment;
	
	public ResponseEntity<List<Address>> getAllAddresses(){
		List<Address> addresses=addressRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(addresses);
	}
	
	public ResponseEntity<Address> getAddress(int id){
		Address address=addressRepository.findById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(address);
	}
	
	public Address getAddressByEmployeeId(int employeeId) {
		System.out.println("finding employee address on port..."+environment.getProperty("local.server.port"));
		return addressRepository.getAddressByEmployeeId(employeeId);
	}

	public Address addAddress(Address address) {
		Address savedAddress=addressRepository.save(address);
		return savedAddress;
	}
}
