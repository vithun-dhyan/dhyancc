package com.dhyancc.handson.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuditLogRepo extends JpaRepository<AuditLog, Long>{

}


