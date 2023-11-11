package com.rahul.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

	@GetMapping("/info/{id}")
	public ResponseEntity<String> getCourseInfo(@PathVariable Integer id) {

		String body = null;

		if (id == 5)
			body = "Spring Boot - Microservices Batch";
		else if (id == 6)
			body = "Hibernate Batch";
		else
			body = "Contact to Administrator about the batch";

		return new ResponseEntity<String>(body, HttpStatus.OK);

	}

	@GetMapping("/info/{id}/JRTP/{name}")
	public ResponseEntity<String> getCourseDetails(@PathVariable Integer id, @PathVariable String name) {

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
