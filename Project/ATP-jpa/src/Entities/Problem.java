package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Problem
 *
 */
@Entity

public class Problem implements Serializable {

	   
	@Id
	private String ProblemID;
	@Column(name ="ContestID")
	private String ContestID;
	private String ProblemName;
	@Column(nullable = false)
	private float TimeLimit;
	private int MemoryLimit;
	private int NumSubmission;
	private int NumCorrectSubmission;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="ContestID", insertable = false, updatable = false)
	private Contest Contest;
	
	@OneToMany(mappedBy="Problem")
	private List<Submission> Submissions;
	
	@OneToMany(mappedBy="Problem")
	private List<Input> Inputs;
	
	@OneToMany(mappedBy="Problem")
	private List<Output> Outputs;
	
	public Problem() {
		super();
	}   
	public String getProblemID() {
		return this.ProblemID;
	}

	public void setProblemID(String ProblemID) {
		this.ProblemID = ProblemID;
	}   
	public String getContestID() {
		return this.ContestID;
	}

	public void setContestID(String ContestID) {
		this.ContestID = ContestID;
	}   
	public String getProblemName() {
		return this.ProblemName;
	}

	public void setProblemName(String ProblemName) {
		this.ProblemName = ProblemName;
	}   
	public float getTimeLimit() {
		return this.TimeLimit;
	}

	public void setTimeLimit(float TimeLimit) {
		this.TimeLimit = TimeLimit;
	}   
	public int getMemoryLimit() {
		return this.MemoryLimit;
	}

	public void setMemoryLimit(int MemoryLimit) {
		this.MemoryLimit = MemoryLimit;
	}   
	public int getNumSubmission() {
		return this.NumSubmission;
	}

	public void setNumSubmission(int NumSubmission) {
		this.NumSubmission = NumSubmission;
	}   
	public int getNumCorrectSubmission() {
		return this.NumCorrectSubmission;
	}

	public void setNumCorrectSubmission(int NumCorrectSubmission) {
		this.NumCorrectSubmission = NumCorrectSubmission;
	}
   
}
