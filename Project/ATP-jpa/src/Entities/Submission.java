package Entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Submission
 *
 */
@Entity

public class Submission implements Serializable {

	   
	@Id
	private String SubmissionId;
	@Column(name="ProblemId", nullable = false)
	private String ProblemId;
	@Column(name="StudentId", nullable = false)
	private String StudentId;
	@Column(name="ContestId")
	private String ContestId;
	private int NumCorrectOutput;
	private String SendTime;
	private int ContestSubmitTime;
	private int ProblemSubmitTime;
	private String Status;
	private String SourceCode;
	private static final long serialVersionUID = 1L;
	@OneToOne
	private SubmissionResult SubmissionResult;
	
	@ManyToOne
	@JoinColumn(name="ProblemId", insertable = false, updatable = false)
	private Problem Problem;
	
	@ManyToOne
	@JoinColumn(name="StudentId", insertable = false, updatable = false)
	private Student Student;
	
	@ManyToOne
	@JoinColumn(name="ContestId", insertable = false, updatable = false)
	private Contest Contest;
	
	public Submission() {
		super();
	}   
	public String getSubmissionId() {
		return this.SubmissionId;
	}

	public void setSubmissionId(String SubmissionId) {
		this.SubmissionId = SubmissionId;
	}   
	public String getProblemId() {
		return this.ProblemId;
	}

	public void setProblemId(String ProblemId) {
		this.ProblemId = ProblemId;
	}   
	public String getStudentId() {
		return this.StudentId;
	}

	public void setStudentId(String StudentId) {
		this.StudentId = StudentId;
	}   
	public String getContestId() {
		return this.ContestId;
	}

	public void setContestId(String ContestId) {
		this.ContestId = ContestId;
	}   
	public int getNumCorrectOutput() {
		return this.NumCorrectOutput;
	}

	public void setNumCorrectOutput(int NumCorrectOutput) {
		this.NumCorrectOutput = NumCorrectOutput;
	}   
	public String getSendTime() {
		return this.SendTime;
	}

	public void setSendTime(String SendTime) {
		this.SendTime = SendTime;
	}   
	public int getContestSubmitTime() {
		return this.ContestSubmitTime;
	}

	public void setContestSubmitTime(int ContestSubmitTime) {
		this.ContestSubmitTime = ContestSubmitTime;
	}   
	public int getProblemSubmitTime() {
		return this.ProblemSubmitTime;
	}

	public void setProblemSubmitTime(int ProblemSubmitTime) {
		this.ProblemSubmitTime = ProblemSubmitTime;
	}   
	public String getStatus() {
		return this.Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}
	public String getSourceCode() {
		return SourceCode;
	}
	public void setSourceCode(String sourceCode) {
		SourceCode = sourceCode;
	}
	
   
}
