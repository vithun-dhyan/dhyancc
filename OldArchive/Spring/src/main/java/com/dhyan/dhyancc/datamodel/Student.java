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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(of = { "name" })
@NoArgsConstructor
public class Student {

	public static enum Gender {
		MALE, FEMALE, OTHERS
	};

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	private String name;

	private int age;

	private Gender gender;

	@Column(name = "address")
	private String address;

}
