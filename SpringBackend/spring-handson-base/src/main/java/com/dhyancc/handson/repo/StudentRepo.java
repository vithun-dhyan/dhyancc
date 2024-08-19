package com.dhyancc.handson.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhyancc.handson.datamodel.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
