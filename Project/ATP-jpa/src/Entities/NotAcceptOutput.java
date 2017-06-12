package Entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: NotAcceptOutput
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="NotAcceptOutput.GetBySubmissonID",query="Select n from NotAcceptOutput n where n.SubmissionId=:submissionID")
})
@IdClass(NotAcceptOutputPK.class)
public class NotAcceptOutput implements Serializable {

	   
	@Id
	@Column(name="SubmissionId")
	private int SubmissionId;   
	@Id
	private int InputIndex;
	private String StudentOutput;
	private String TeacherOutput;
	private String ErrorMessage;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="SubmissionId", insertable = false, updatable = false)
	private SubmissionResult SubmissionResult;
	public NotAcceptOutput() {
		super();
	}   
	public int getSubmissionId() {
		return this.SubmissionId;
	}

	public void setSubmissionId(int SubmissionId) {
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
	public String getErrorMessage() {
		return this.ErrorMessage;
	}

	public void setErrorMessage(String ErrorMessage) {
		this.ErrorMessage = ErrorMessage;
	}
   
}
