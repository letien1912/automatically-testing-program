package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SubmissionResult
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="SubmissionResult.GetByID",query="Select s from SubmissionResult s where s.SubmissionId=:id")
})
public class SubmissionResult implements Serializable {

	@Id
	@Column(name = "SubmissionId")
	private String SubmissionId;
	private int runtime;
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy = "SubmissionResult")
	@JoinColumn(name = "SubmissionId", insertable = false, updatable = false)
	private Submission Submission;

	@OneToMany(mappedBy="SubmissionResult")
	private List<AcceptOutput> AcceptOutputs;
	
	@OneToMany(mappedBy="SubmissionResult")
	private List<NotAcceptOutput> NotAcceptOutputs; 
	
	public SubmissionResult() {
		super();
	}

	public String getSubmissionId() {
		return this.SubmissionId;
	}

	public void setSubmissionId(String SubmissionId) {
		this.SubmissionId = SubmissionId;
	}

	public int getRuntime() {
		return this.runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

}
