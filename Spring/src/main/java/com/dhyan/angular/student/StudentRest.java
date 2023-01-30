package com.dhyan.angular.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhyan.angular.student.service.StudentServiceImpl;

@RestController
@RequestMapping("api/angular/student-management")
public class StudentRest {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@PostMapping(value = "/student", produces = { "application/json" })
	public Student saveStudent(final @RequestBody Student student) {
		studentServiceImpl.saveStudent(student);
		studentServiceImpl.doAudit(student);
		return student;
	}

	@GetMapping(value = "/student/{id}", produces = { "application/json" })
	public Optional<Student> getStudentById(@PathVariable final long id) {
		Optional<Student> student = studentServiceImpl.getStudentById(id);
		return student;
	}

	@PutMapping(value = "/updatestudent", produces = { "application/json" })
	public Student updateStudent(final @RequestBody Student newStudent) {
		Student student = studentServiceImpl.updateStudent(newStudent);
		return student;
	}

	@GetMapping(value = "/studentlist", produces = { "application/json" })
	public List<Student> getStudentList() {
		List<Student> students = studentRepo.findAll();
		return students;
	}

	@DeleteMapping(value = "/student/{id}", produces = { "application/json" })
	public void deleteStudent(@PathVariable final long id) {
		studentRepo.deleteById(id);
	}

}
