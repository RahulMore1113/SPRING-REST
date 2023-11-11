package com.rahul.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping("/read")
	public ResponseEntity<String> getEmployee(@RequestParam Integer id, @RequestParam String name) {

		String body = null;

		if (id == 21 && name.equalsIgnoreCase("Krishna"))
			body = "GOD LOVE YOU " + name;
		else if (id == 22 && name.equalsIgnoreCase("Rahul"))
			body = "Hi " + name;
		else
			body = "Unknown Name :: " + name + " with id :: " + id;

		return new ResponseEntity<String>(body, HttpStatus.OK);

	}

}
