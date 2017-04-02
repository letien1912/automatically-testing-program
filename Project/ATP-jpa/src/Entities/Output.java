package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Output
 *
 */
@Entity

public class Output implements Serializable {

	@Id @GeneratedValue
	private int OutputId;
	@Column(name="ProblemId")
	private String ProblemId;
	private String OutputTest;
	
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="ProblemId", insertable = false, updatable = false)
	private Problem Problem;
	public Output() {
		super();
	}

	public Output(int outputId, String problemId, String outputTest) {
		super();
		OutputId = outputId;
		ProblemId = problemId;
		OutputTest = outputTest;
	}

	public int getOutputId() {
		return OutputId;
	}

	public void setOutputId(int outputId) {
		OutputId = outputId;
	}

	public String getProblemId() {
		return ProblemId;
	}

	public void setProblemId(String problemId) {
		ProblemId = problemId;
	}

	public String getOutputTest() {
		return OutputTest;
	}

	public void setOutputTest(String outputTest) {
		OutputTest = outputTest;
	}
	
   
}
