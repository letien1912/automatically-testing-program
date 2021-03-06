package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Contest
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Contest.GetAll",query="Select c from Contest c"),
	@NamedQuery(name="Contest.GetByID",query="Select c from Contest c where c.ContestId=:contestID")
})
public class Contest implements Serializable {

	@Id
	private String ContestId;
	@Column(nullable = false)
	private String ContestName;
	@Column(nullable = false)
	private String CreatedTime;
	@Column(name="TeacherId", nullable = false)
	private String TeacherId;
	private int TotalSubmission;
	private int TotalCorrectSubmission;
	private String Status;

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="TeacherId", insertable = false, updatable = false)
	private Teacher Teacher;
	
	@OneToMany(mappedBy="Contest")
	private List<Student_ContestDetail> ContestDetails;
	
	@OneToMany(mappedBy="Contest")
	private List<Problem> Problems;

	@OneToMany(mappedBy="Contest")
	private List<Submission> Submissions;
	public Contest() {
		super();
	}

	public Contest(String contestId, String contestName, String createdTime, int totalSubmission,
			int totalCorrectSubmission, String status) {
		super();
		ContestId = contestId;
		ContestName = contestName;
		CreatedTime = createdTime;
		TotalSubmission = totalSubmission;
		TotalCorrectSubmission = totalCorrectSubmission;
		Status = status;
	}

	public String getContestId() {
		return this.ContestId;
	}

	public void setContestId(String ContestId) {
		this.ContestId = ContestId;
	}

	public String getContestName() {
		return this.ContestName;
	}

	public void setContestName(String ContestName) {
		this.ContestName = ContestName;
	}

	public String getCreatedTime() {
		return this.CreatedTime;
	}

	public void setCreatedTime(String CreatedTime) {
		this.CreatedTime = CreatedTime;
	}

	public int getTotalSubmission() {
		return this.TotalSubmission;
	}

	public void setTotalSubmission(int TotalSubmission) {
		this.TotalSubmission = TotalSubmission;
	}

	public int getTotalCorrectSubmission() {
		return this.TotalCorrectSubmission;
	}

	public void setTotalCorrectSubmission(int TotalCorrectSubmission) {
		this.TotalCorrectSubmission = TotalCorrectSubmission;
	}

	public String getStatus() {
		return this.Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

}
