package com.rahul.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@GetMapping("/report/{id}")
	public ResponseEntity<Customer> showAllCustomer(@PathVariable Integer id) {

		System.out.println("Customer data for the id :: " + id);

		Customer customer = new Customer();
		customer.setCno(id);
		customer.setCname("Rahul");
		customer.setBillAmount(67243.4f);

		return new ResponseEntity<>(customer, HttpStatus.OK);

	}

	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {

		System.out.println(customer);

		Integer id = 10;
		String body = "Customer Register with the id :: " + id;

		return new ResponseEntity<String>(body, HttpStatus.OK);

	}

}
