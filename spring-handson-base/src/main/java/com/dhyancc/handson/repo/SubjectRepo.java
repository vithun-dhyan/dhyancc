package com.dhyancc.handson.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhyancc.handson.datamodel.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {

}
