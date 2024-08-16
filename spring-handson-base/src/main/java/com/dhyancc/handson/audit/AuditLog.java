package com.dhyancc.handson.audit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
