package com.dhyan.dhyancc.datamodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.dhyan.dhyancc.datamodel.Student.Gender;

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
