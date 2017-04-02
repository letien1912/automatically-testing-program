package Entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: NotAcceptOutput
 *
 */
@Entity

public class NotAcceptOutput implements Serializable {

	   
	@Id
	@Column(name="SubmissionId")
	private String SubmissionId;
	private int InputIndex;
	private String StudentOutput;
	private String TeacherOutput;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="SubmissionId")
	private SubmissionResult SubmissionResult;
	
	public NotAcceptOutput() {
		super();
	}   
	public String getSubmissionId() {
		return this.SubmissionId;
	}

	public void setSubmissionId(String SubmissionId) {
		this.SubmissionId = SubmissionId;
	}   
	public int getInputIndex() {
		return this.InputIndex;
	}

	public void setInputIndex(int InputIndex) {
		this.InputIndex = InputIndex;
	}   
	public String getStudentOutput() {
		return this.StudentOutput;
	}

	public void setStudentOutput(String StudentOutput) {
		this.StudentOutput = StudentOutput;
	}   
	public String getTeacherOutput() {
		return this.TeacherOutput;
	}

	public void setTeacherOutput(String TeacherOutput) {
		this.TeacherOutput = TeacherOutput;
	}
   
}
