package com.example.addressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.addressservice.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	@Query(nativeQuery = true, value = "select a.id, a.city, a.pincode, a.employee_id from mydb1.address a join mydb1.employee e on e.id=a.employee_id where a.employee_id=:employeeId")
	public Address getAddressByEmployeeId(@Param("employeeId") int employeeId);
	
	@Query(nativeQuery = true, value= "UPDATE mydb1.address a SET a.employee_id=:employeeId WHERE a.id=:addressId;")
	void addAddress(@Param("employeeId") int employeeId, @Param("addressId") int addressId);
}