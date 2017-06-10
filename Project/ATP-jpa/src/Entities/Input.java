package Entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Input
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Input.GetByInput_ProblemID", query="Select i from Input i where i.InputId=:inputID "
			+ "and i.ProblemId=:problemID"),
	@NamedQuery(name="Input.GetByProblemID", query="Select i from Input i where i.ProblemId=:problemId")
	
})
@IdClass(InputPK.class)
public class Input implements Serializable {

	   
	@Id @GeneratedValue
	private int InputId;   
	@Id @Column(name="ProblemId")
	private String ProblemId;
	private String InputData;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="ProblemId", insertable = false, updatable = false)
	private Problem Problem;
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
	public String getInputData() {
		return this.InputData;
	}

	public void setInputData(String InputData) {
		this.InputData = InputData;
	}
   
}
