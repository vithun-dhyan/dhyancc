package com.dhyan.angular.student.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;  


import com.dhyan.angular.audit.AuditLog;
import com.dhyan.angular.audit.AuditLogRepo;
import com.dhyan.angular.student.Student;
import com.dhyan.angular.student.StudentRepo;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private AuditLogRepo auditLogRepo;

	@Override
	public Student saveStudent(Student student) {
		studentRepo.save(student);
		return student;
	}

	@Override
	public Optional<Student> getStudentById(final long id) {
		Optional<Student> student = studentRepo.findById(id);
		return student;
	}

	@Override
	public Student updateStudent(Student newStudent) {
		Student student = studentRepo.save(newStudent);
		return student;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void doAudit(Student student)
	{
		AuditLog auditlog = new AuditLog();
		auditlog.setTime(System.currentTimeMillis());
		auditlog.setMessage(student.getName()+" student is saved successfully");
		auditLogRepo.save(auditlog);
	}

}
