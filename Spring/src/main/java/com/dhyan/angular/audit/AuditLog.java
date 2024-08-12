package com.dhyan.angular.audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "AUDITLOG")
@Data
public class AuditLog {

	public static enum Operation {
		ADD, UPDATE, DELETE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seqauditid")
	@SequenceGenerator(name = "seqauditid", sequenceName = "seqauditid", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private long id;

	private long time;
	
	private Operation operation;

	@Column(length = 512)
	private String message;



}
