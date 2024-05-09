package com.example.employeeservice.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.employeeservice.feignclient.AddressFeignClient;
import com.example.employeeservice.model.Address;
import com.example.employeeservice.model.AddressData;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.model.EmployeeData;
import com.example.employeeservice.model.EmployeeResponse;
import com.example.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressFeignClient addressFeignClient;
	
	public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeResponse> employeeResponses=new ArrayList<>();
		List<Address> addresses=addressFeignClient.getAllAddresses().getBody();
		for (int i=0; i<employees.size(); i++) {
			EmployeeResponse employeeResponse=new EmployeeResponse();
			employeeResponse.setId(employees.get(i).getId());
			employeeResponse.setName(employees.get(i).getName());
			employeeResponse.setAge(employees.get(i).getAge());
			for (Address address: addresses) {
				if (address.getEmployeeId()==employeeResponse.getId()) {
					employeeResponse.setAddress(address);
				}
			}
			employeeResponses.add(employeeResponse);
		}
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
	}
	
	
	public ResponseEntity<EmployeeResponse> getEmployee(int employeeId){
		Employee employee=employeeRepository.findById(employeeId).get();
		EmployeeResponse employeeResponse=new EmployeeResponse();
		employeeResponse.setId(employee.getId());
		employeeResponse.setName(employee.getName());
		employeeResponse.setAge(employee.getAge());
		employeeResponse.setAddress(addressFeignClient.getAddressByEmployeeId(employeeId));
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}


	public ResponseEntity<EmployeeResponse> addEmployee(EmployeeData employeeData) {
		Employee employee=new Employee();
		employee.setName(employeeData.getName());
		employee.setAge(employeeData.getAge());
		Employee addedEmployee=employeeRepository.save(employee);
		AddressData addressData=employeeData.getAddressData();
		Address address=new Address();
		address.setCity(addressData.getCity());
		address.setPincode(addressData.getPincode());
		address.setEmployeeId(addedEmployee.getId());
		Address newAddress= addressFeignClient.addAddress(address);
		EmployeeResponse employeeResponse=new EmployeeResponse();
		employeeResponse.setId(addedEmployee.getId());
		employeeResponse.setName(addedEmployee.getName());
		employeeResponse.setAge(addedEmployee.getAge());
		employeeResponse.setAddress(newAddress);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
	}
}


























