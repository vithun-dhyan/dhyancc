package com.dhyan.angular.student.service;

import java.util.List;
import java.util.Optional;

import com.dhyan.angular.student.Student;

public interface StudentServiceI {

	List<Student> findAll();

	Student saveStudent(Student student);

	Optional<Student> getStudentById(long id);

	Student updateStudent(Student student);
	
	boolean deleteStudent(long id);
}
