package Entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Input
 *
 */
@Entity

public class Input implements Serializable {

	   
	@Id @GeneratedValue
	private int InputId;
	@Column(name="ProblemId")
	private String ProblemId;
	private String InputTest;
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="ProblemId", insertable = false, updatable = false)
	private Problem Problem;
	
	public Input(int inputId, String problemId, String inputTest) {
		super();
		InputId = inputId;
		ProblemId = problemId;
		InputTest = inputTest;
	}
	public Input() {
		super();
	}   
	public int getInputId() {
		return this.InputId;
	}

	public void setInputId(int InputId) {
		this.InputId = InputId;
	}   
	public String getProblemId() {
		return this.ProblemId;
	}

	public void setProblemId(String ProblemId) {
		this.ProblemId = ProblemId;
	}   
	public String getInputTest() {
		return this.InputTest;
	}

	public void setInputTest(String InputTest) {
		this.InputTest = InputTest;
	}
   
}