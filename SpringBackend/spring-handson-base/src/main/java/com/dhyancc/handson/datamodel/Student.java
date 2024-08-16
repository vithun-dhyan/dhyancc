package com.dhyancc.handson.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
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


	private String name;

	private int age;

	private Gender gender;

	@Column(name = "address")
	private String address;

}
