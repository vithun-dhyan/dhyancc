package com.dhyan.angular.student.service;

import java.util.Optional;

import com.dhyan.angular.student.Student;

public interface StudentServiceI {

	Student saveStudent(Student student);

	Optional<Student> getStudentById(long id);

	Student updateStudent(Student student);
	
	void doAudit(Student student);
}
