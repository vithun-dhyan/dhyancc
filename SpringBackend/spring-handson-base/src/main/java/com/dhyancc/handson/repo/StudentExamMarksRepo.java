package com.dhyancc.handson.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhyancc.handson.datamodel.StudentExamMarks;

@Repository
public interface StudentExamMarksRepo extends JpaRepository<StudentExamMarks, StudentExamMarks.StudentExamID>{

}
