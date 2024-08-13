package com.dhyan.dhyancc.components;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhyan.dhyancc.datamodel.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
