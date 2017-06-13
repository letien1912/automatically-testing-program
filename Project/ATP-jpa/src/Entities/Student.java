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
@NamedQueries({
	@NamedQuery(name="Student.GetByID",query="Select s from Student s where s.StudentId=:studentID"),
	@NamedQuery(name="Student.GetAll",query="Select s from Student s"),
	@NamedQuery(name="Student.GetByUserName",query="Select s from Student s where s.UserName=:userName")
})
public class Student implements Serializable {

	   
	@Id
	private String StudentId;
	@Column(nullable = false)
	private String StudentName;
	@Column(nullable = false)
	private String UserName;
	@Column(nullable = false)
	private String Password;
	private int IsActive;
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
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getIsActive() {
		return IsActive;
	}
	public void setIsActive(int isActive) {
		IsActive = isActive;
	}
	
   
}
