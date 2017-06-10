package Entities;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Output
 *
 */ 
public class OutputPK  implements Serializable {   
   
	         
	private int OutputId;         
	private String ProblemId;
	private static final long serialVersionUID = 1L;

	public OutputPK() {}

	

	public int getOutputId() {
		return this.OutputId;
	}

	public void setOutputId(int OutputId) {
		this.OutputId = OutputId;
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
		if (!(o instanceof OutputPK)) {
			return false;
		}
		OutputPK other = (OutputPK) o;
		return true
			&& getOutputId() == other.getOutputId()
			&& (getProblemId() == null ? other.getProblemId() == null : getProblemId().equals(other.getProblemId()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getOutputId();
		result = prime * result + (getProblemId() == null ? 0 : getProblemId().hashCode());
		return result;
	}
   
   
}
