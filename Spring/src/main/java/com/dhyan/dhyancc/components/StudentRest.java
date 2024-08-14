package com.dhyan.dhyancc.components;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhyan.dhyancc.datamodel.Student;
import com.dhyan.dhyancc.datamodel.Student.Gender;
import com.dhyan.dhyancc.exceptions.CannotUpdateID;
import com.dhyan.dhyancc.service.StudentServiceI;

@RestController
@RequestMapping("api/angular/student-management")
public class StudentRest {

	@Autowired
	private StudentServiceI studentService;

	@PostMapping(value = "/create-random-student", produces = { "application/json" })
	public Student createRandomStudent() {
		Random rand = new Random();

		String randStr = Long.toHexString(rand.nextLong());
		Student student = new Student();
		student.setName("Random" + randStr);
		student.setAge(rand.nextInt(1, 100));
		student.setGender(rand.nextBoolean() ? Gender.MALE : Gender.FEMALE);
		student.setAddress(randStr);
		student = studentService.saveStudent(student);
		return student;

	}

	@PostMapping(value = "/students", produces = { "application/json" })
	public Student saveStudent(final @RequestBody Student student) {
		studentService.saveStudent(student);
		return student;
	}

	@GetMapping(value = "/students/{id}", produces = { "application/json" })
	public Optional<Student> getStudentById(@PathVariable final long id) {
		Optional<Student> student = studentService.getStudentById(id);
		return student;
	}

	@PutMapping(value = "/students/{id}", produces = { "application/json" })
	public Student updateStudent(@PathVariable final long id, final @RequestBody Student studentToUpdate)
			throws CannotUpdateID {
		if (studentToUpdate.getId() != null && id != studentToUpdate.getId()) {
			throw new CannotUpdateID(String.format("%s passed in the path is not the same as %s in the request body",
					id, studentToUpdate.getId()));
		}
		studentToUpdate.setId(id);
		Student student = studentService.updateStudent(studentToUpdate);
		return student;
	}

	@GetMapping(value = "/students", produces = { "application/json" })
	public List<Student> getStudentList() {
		List<Student> students = studentService.findAll();
		return students;
	}

	@DeleteMapping(value = "/students/{id}", produces = { "application/json" })
	public ResponseEntity<Void> deleteStudent(@PathVariable final long id) {
		boolean isPresent = studentService.deleteStudent(id);
		return isPresent ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}

}
