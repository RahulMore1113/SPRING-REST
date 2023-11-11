package com.rahul.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.model.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
