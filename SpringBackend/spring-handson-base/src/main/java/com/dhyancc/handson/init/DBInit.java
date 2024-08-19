package com.dhyancc.handson.init;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhyancc.handson.datamodel.Exam;
import com.dhyancc.handson.datamodel.Student;
import com.dhyancc.handson.datamodel.Student.Gender;
import com.dhyancc.handson.datamodel.StudentExamMarks;
import com.dhyancc.handson.datamodel.StudentExamMarks.StudentExamID;
import com.dhyancc.handson.datamodel.Subject;
import com.dhyancc.handson.repo.ExamRepo;
import com.dhyancc.handson.repo.StudentExamMarksRepo;
import com.dhyancc.handson.repo.StudentRepo;
import com.dhyancc.handson.repo.SubjectRepo;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DBInit {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private SubjectRepo subjectRepo;

	@Autowired
	private ExamRepo examRepo;

	@Autowired
	private StudentExamMarksRepo studentExamMarksRepo;

	@PostConstruct
	public void init() {
		if (studentRepo.count() > 0) {
			log.info("data already exists");
			return;
		}

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

			StudentExamMarks studentExamMarks = new StudentExamMarks();
			studentExamMarks.setStudentExamID(new StudentExamID(exam1, student1));
			studentExamMarks.setMarks(50);
			studentExamMarksRepo.save(studentExamMarks);

		} catch (Throwable e) {
			log.error("Something went wrong while inserting default records", e);
		}

	}
}
