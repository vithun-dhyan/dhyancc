package com.dhyancc.handson.datamodel;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(of = { "studentExamID" })
@NoArgsConstructor
public class StudentExamMarks {

	@Embeddable
	@Data
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class StudentExamID implements Serializable {
		@ManyToOne
		private Exam exam;
		@ManyToOne
		private Student student;
	}

	@EmbeddedId
	private StudentExamID studentExamID;

	private Integer marks;

}
