package com.rahul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.dao.IStudentRepo;
import com.rahul.exception.StudentRecordNotFoundException;
import com.rahul.model.Student;

@Service
public class IStudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepo repo;

	@Override
	public String saveStudent(Student student) {

		return "Student Record save with the id :: " + repo.save(student).getSid();

	}

	@Override
	public List<Student> findAllStudents() {

		return repo.findAll();

	}

	@Override
	public Student findById(Integer id) {

		return repo.findById(id)
				.orElseThrow(() -> new StudentRecordNotFoundException("Record not found for given id :: " + id));

	}

	@Override
	public String updateStudent(Student student) {

		return "Student Record updated with the id :: " + repo.save(student).getSid();

	}

	@Override
	public String deleteById(Integer id) {

		Student student = repo.findById(id)
				.orElseThrow(() -> new StudentRecordNotFoundException("Student not found for given id :: " + id));

		repo.delete(student);

		return "Record Deleted";

	}

}
