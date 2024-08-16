package com.dhyancc.handson.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhyancc.handson.datamodel.Exam;

@Repository
public interface ExamRepo extends JpaRepository<Exam, Long>{

}
