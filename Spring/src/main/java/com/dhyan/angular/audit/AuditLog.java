package com.dhyan.angular.audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AUDITLOG")
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seqauditid")
	@SequenceGenerator(name = "seqauditid", sequenceName = "seqauditid", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private long id ;
	
	private long time;

	private String message;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
