package Entities;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: NotAcceptOutput
 *
 */ 
public class NotAcceptOutputPK  implements Serializable {   
   
	         
	private String SubmissionId;         
	private int InputIndex;
	private static final long serialVersionUID = 1L;

	public NotAcceptOutputPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof NotAcceptOutputPK)) {
			return false;
		}
		NotAcceptOutputPK other = (NotAcceptOutputPK) o;
		return true
			&& (getSubmissionId() == null ? other.getSubmissionId() == null : getSubmissionId().equals(other.getSubmissionId()))
			&& getInputIndex() == other.getInputIndex();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getSubmissionId() == null ? 0 : getSubmissionId().hashCode());
		result = prime * result + getInputIndex();
		return result;
	}
   
   
}
