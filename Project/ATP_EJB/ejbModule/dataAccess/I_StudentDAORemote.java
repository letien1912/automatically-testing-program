package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.Student;
import exceptionHandl.ATP_ExceptionHandler;

@Remote
public interface I_StudentDAORemote {
	public void CreateStudent(Student student) throws ATP_ExceptionHandler;
	public void DeleteStudent(Student student) throws ATP_ExceptionHandler;
	public void EditStudent(Student student) throws ATP_ExceptionHandler;
	public Student GetStudentByID(String studentID) throws ATP_ExceptionHandler;
	public Student GetStudentByUserName(String userName) throws ATP_ExceptionHandler;
	public List<Student> GetAllStudent() throws ATP_ExceptionHandler;
}
