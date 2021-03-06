package Entities;

import java.io.Serializable;

/**
 * ID class for entity: AcceptOutput
 *
 */ 
public class AcceptOutputPK  implements Serializable {   
   
	         
	private int SubmissionId;         
	private int InputIndex;
	private static final long serialVersionUID = 1L;

	public AcceptOutputPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof AcceptOutputPK)) {
			return false;
		}
		AcceptOutputPK other = (AcceptOutputPK) o;
		return true
			&& getSubmissionId() ==  other.getSubmissionId() 
			&& getInputIndex() == other.getInputIndex();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getSubmissionId();
		result = prime * result + getInputIndex();
		return result;
	}
   
   
}
