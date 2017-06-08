package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Teacher
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Teacher.findAll",
                query="SELECT t FROM Teacher t"),
    @NamedQuery(name="Teacher.findByName",
                query="SELECT t FROM Teacher t WHERE t.TeacherName = :name"),
    @NamedQuery(name="Teacher.findAllContestCreatedByTeacher",
    			query="SELECT c FROM Contest c WHERE c.TeacherId = :id"),
}) 
public class Teacher implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String TeacherId;
	@Column(name = "TeacherName",nullable=false)
	private String TeacherName;
	@Column(nullable = false)
	private String UserName;
	@Column(nullable = false)
	private String Password;
	
	@OneToMany(mappedBy="Teacher")
	private List<Contest> contests;
	
	public Teacher(String teacherId, String teacherName) {
		super();
		TeacherId = teacherId;
		TeacherName = teacherName;
	}
	public Teacher() {
		super();
	}   
	public String getTeacherId() {
		return this.TeacherId;
	}

	public void setTeacherId(String TeacherId) {
		this.TeacherId = TeacherId;
	}   
	public String getTeacherName() {
		return this.TeacherName;
	}

	public void setTeacherName(String TeacherName) {
		this.TeacherName = TeacherName;
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
	
   
}
