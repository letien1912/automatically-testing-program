package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.Student_ContestDetail;
import exceptionHandl.ATP_ExceptionHandler;

@Remote
public interface I_Student_ContestDAORemote {
	public void CreateStudentContestDetail(Student_ContestDetail student_ContestDetail) throws ATP_ExceptionHandler;
	public List<Student_ContestDetail> GetAllStudentContestDetail() throws ATP_ExceptionHandler;
	public Student_ContestDetail GetStudent_ContestDetail(String studentID, String contestID) throws ATP_ExceptionHandler;
	public List<Student_ContestDetail> GetStudentContestDetailByContestID (String contestID) throws ATP_ExceptionHandler;
	public List<Student_ContestDetail> GetStudentContestDetailByStudentID(String studentID) throws ATP_ExceptionHandler;
}
