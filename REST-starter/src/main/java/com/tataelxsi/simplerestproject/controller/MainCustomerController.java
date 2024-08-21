package com.tataelxsi.simplerestproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tataelxsi.simplerestproject.model.Customer;

@RestController
@RequestMapping("/customer")

public class MainCustomerController {

	List<Customer> newcustomer = new ArrayList<>();

	@PostMapping("/create")
	public String createCustomerData(@RequestBody Customer customer) {

		newcustomer.add(customer);

		if (newcustomer.isEmpty()) {

			return "recored not created properly";
		}

		return "record created";

	}

	@GetMapping("/display")
	public Customer getCustomerDetails(@RequestParam Long customerId,
			@RequestParam String customerName,
			@RequestParam String productName) {

		return new Customer(customerId, customerName, productName);

	}

	@GetMapping("/display/{customerId}")
	public Customer getCustomerID(@PathVariable Long customerId) {

		Customer getCustomer = null;

		for (Customer i : newcustomer) {

			if (i.getCustomerId() == customerId) {

				getCustomer = i;
				break;
			}
		}

		return getCustomer;
	}

	@PutMapping("/update")
	public String updateCustomerDetails(@RequestBody Customer customer) {
		
		String updateVal = "null" ;
		for(Customer checkCustomer : newcustomer) {
			
			if(checkCustomer.getCustomerId()==customer.getCustomerId()) {
				
				newcustomer.set(0, customer);
				break;
			}
			
		}
		
		if(newcustomer.contains(customer)) {
			
			updateVal = "Set";
		}
		
		return "record updated successfully at status : " + updateVal ;
	}
	
	@DeleteMapping("/delete/{customerId}")
	public String deleteCustomerDetails(@PathVariable Long customerId) {
		
		String deleteVal = "null";
		Customer deletedCustomer = null;
		for(Customer checkCustomer : newcustomer) {
			
			if(checkCustomer.getCustomerId() == customerId) {
				
				deletedCustomer = checkCustomer;
				newcustomer.remove(checkCustomer);
				break;
			}
			
		}
		
		if(newcustomer.contains(deletedCustomer)) {
			
			deleteVal = "deleted";
		}
		
		return "record deleted at status : " + deleteVal + 
				"where deleted obj is : " + 
		deletedCustomer.toString();
	}

}
