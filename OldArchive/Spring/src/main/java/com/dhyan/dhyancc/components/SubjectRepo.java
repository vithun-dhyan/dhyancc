package com.dhyan.dhyancc.components;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhyan.dhyancc.datamodel.Exam;
import com.dhyan.dhyancc.datamodel.StudentExamMarks;
import com.dhyan.dhyancc.datamodel.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {

}
