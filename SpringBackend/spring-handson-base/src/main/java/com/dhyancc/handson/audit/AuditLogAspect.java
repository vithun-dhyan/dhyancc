package com.dhyancc.handson.audit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dhyancc.handson.audit.AuditLog.Operation;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class AuditLogAspect {

	@Autowired
	private AuditLogRepo auditLogRepo;

	@Around("execution(* org.springframework.data.repository.CrudRepository.save(..))")
	public Object logRepositoryAccess_save(final ProceedingJoinPoint pjp) throws Throwable {
		var ret = pjp.proceed();
		if (!(ret instanceof AuditLog))
			doAudit(ret, Operation.UPDATE);
		return ret;

	}

	@Around("execution(* org.springframework.data.repository.CrudRepository.delete(..))")
	public Object logRepositoryAccess_delete(final ProceedingJoinPoint pjp) throws Throwable {
		var ret = pjp.proceed();
		if (!(pjp.getArgs()[0] instanceof AuditLog))
			doAudit(pjp.getArgs()[0], Operation.DELETE);
		return ret;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void doAudit(Object obj, AuditLog.Operation op) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AuditLog auditlog = new AuditLog();
		auditlog.setTime(System.currentTimeMillis());
		if (auth != null) {
			auditlog.setUsername(auth.getName());
		}
		auditlog.setMessage(String.format("Type: %s, val:%s", obj.getClass().getSimpleName(), String.valueOf(obj)));
		log.info(auditlog.getMessage());
		auditlog.setOperation(op);
		auditLogRepo.save(auditlog);
	}
}
