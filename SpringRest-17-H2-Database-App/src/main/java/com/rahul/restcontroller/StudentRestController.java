package com.rahul.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.model.Student;
import com.rahul.service.IStudentService;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;

	@PostMapping("/register")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {

		String body = service.saveStudent(student);

		return new ResponseEntity<String>(body, HttpStatus.OK);

	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayAllStudents() {

		List<Student> students = service.findAllStudents();

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayStudentById(@PathVariable Integer id) {

		Student student = service.findById(id);

		return new ResponseEntity<Student>(student, HttpStatus.OK);

	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyStudent(@RequestBody Student student) {

		String msg = service.updateStudent(student);

		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable Integer id) {

		String msg = service.deleteById(id);

		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

}
