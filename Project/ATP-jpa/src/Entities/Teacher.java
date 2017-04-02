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

public class Teacher implements Serializable {

	   
	@Id @GeneratedValue
	private int TeacherId;
	@Column(name = "TeacherName",nullable=false)
	private String TeacherName;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="Teacher")
	private List<Contest> contests;
	
	public Teacher(int teacherId, String teacherName) {
		super();
		TeacherId = teacherId;
		TeacherName = teacherName;
	}
	public Teacher() {
		super();
	}   
	public int getTeacherId() {
		return this.TeacherId;
	}

	public void setTeacherId(int TeacherId) {
		this.TeacherId = TeacherId;
	}   
	public String getTeacherName() {
		return this.TeacherName;
	}

	public void setTeacherName(String TeacherName) {
		this.TeacherName = TeacherName;
	}
   
}