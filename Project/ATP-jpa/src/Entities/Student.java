package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student implements Serializable {

	   
	@Id
	private String StudentId;
	@Column(nullable = false)
	private String StudentName;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "Student")
	private List<Student_ContestDetail> contestDetails;

	@OneToMany(mappedBy="Student")
	private List<Submission> Submissions;
	
	public Student(String studentId, String studentName) {
		super();
		StudentId = studentId;
		StudentName = studentName;
	}
	public Student() {
		super();
	}   
	public String getStudentId() {
		return this.StudentId;
	}

	public void setStudentId(String StudentId) {
		this.StudentId = StudentId;
	}   
	public String getStudentName() {
		return this.StudentName;
	}

	public void setStudentName(String StudentName) {
		this.StudentName = StudentName;
	}
   
}
