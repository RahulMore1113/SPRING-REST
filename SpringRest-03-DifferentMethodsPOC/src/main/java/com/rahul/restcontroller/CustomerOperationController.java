package com.rahul.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerOperationController {

	@GetMapping("/report")
	public ResponseEntity<String> showCustomerReport() {

		return new ResponseEntity<String>("FROM GET-showCustomerReport Method", HttpStatus.OK);

	}

	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer() {

		return new ResponseEntity<String>("FROM POST-registerCustomer Method", HttpStatus.OK);

	}

	@PatchMapping("/pmodify")
	public ResponseEntity<String> updateCustomerByNo() {

		return new ResponseEntity<String>("FROM PATCH - updateCustomerByNo Method", HttpStatus.OK);

	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateCustomer() {

		return new ResponseEntity<String>("FROM PUT - updateCustomer Method", HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer() {

		return new ResponseEntity<String>("FROM DELETE - deleteCustomer Method", HttpStatus.OK);

	}

}
