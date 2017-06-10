package Entities;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Input
 *
 */ 
public class InputPK  implements Serializable {   
   
	         
	private int InputId;         
	private String ProblemId;
	private static final long serialVersionUID = 1L;

	public InputPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof InputPK)) {
			return false;
		}
		InputPK other = (InputPK) o;
		return true
			&& getInputId() == other.getInputId()
			&& (getProblemId() == null ? other.getProblemId() == null : getProblemId().equals(other.getProblemId()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getInputId();
		result = prime * result + (getProblemId() == null ? 0 : getProblemId().hashCode());
		return result;
	}
   
   
}
