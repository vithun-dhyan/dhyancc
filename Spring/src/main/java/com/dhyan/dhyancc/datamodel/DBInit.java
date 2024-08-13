package com.dhyan.dhyancc.datamodel;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhyan.dhyancc.components.ExamRepo;
import com.dhyan.dhyancc.components.StudentRepo;
import com.dhyan.dhyancc.components.SubjectRepo;
import com.dhyan.dhyancc.datamodel.Student.Gender;

@Component
public class DBInit {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private SubjectRepo subjectRepo;

	@Autowired
	private ExamRepo examRepo;

	@PostConstruct
	public void init() {

		try {

			Student student1 = new Student();
			student1.setName("StudentA");
			student1.setAge(10);
			student1.setGender(Gender.MALE);
			student1.setAddress("123 Address");
			student1 = studentRepo.save(student1);

			Student student2 = new Student();
			student2.setName("StudentB");
			student2.setAge(10);
			student2.setGender(Gender.FEMALE);
			student2.setAddress("456 Address");
			student2 = studentRepo.save(student2);

			Subject subject1 = new Subject();
			subject1.setName("Maths");
			subject1 = subjectRepo.save(subject1);

			Subject subject2 = new Subject();
			subject2.setName("Science");
			subject2 = subjectRepo.save(subject2);

			Calendar cal = Calendar.getInstance();
			cal.set(2024, 8, 11);
			
			
			Exam exam1 = new Exam();
			exam1.setSubject(subject1);
			exam1.setDate(cal.getTime());
			exam1 = examRepo.save(exam1);
			
			Exam exam2 = new Exam();
			exam2.setSubject(subject2);
			exam2.setDate(cal.getTime());
			exam2 = examRepo.save(exam2);
			

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
