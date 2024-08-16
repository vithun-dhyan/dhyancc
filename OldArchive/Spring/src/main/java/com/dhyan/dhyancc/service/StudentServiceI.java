package com.dhyan.dhyancc.service;

import java.util.List;
import java.util.Optional;

import com.dhyan.dhyancc.datamodel.Student;

public interface StudentServiceI {

	List<Student> findAll();

	Student saveStudent(Student student);

	Optional<Student> getStudentById(long id);

	Student updateStudent(Student student);
	
	boolean deleteStudent(long id);
}
