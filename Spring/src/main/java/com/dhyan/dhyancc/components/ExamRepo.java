package com.dhyan.dhyancc.components;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhyan.dhyancc.datamodel.Exam;

@Repository
public interface ExamRepo extends JpaRepository<Exam, Long>{

}
