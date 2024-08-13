package com.dhyan.dhyancc.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(of={"name"})
public class Student {

	public static enum Gender {
		MALE, FEMALE, OTHERS
	};

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seqstudentid")
	@SequenceGenerator(name = "seqstudentid", sequenceName = "seqstudentid", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private long id;

	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	private String name;

	private int age;

	private Gender gender;

	@Column(name = "address")
	private String address;

}
