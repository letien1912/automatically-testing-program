package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.Submission;
import exceptionHandl.ATP_ExceptionHandler;

@Remote
public interface I_SubmissionDAORemote {
	public void CreateSubmission(Submission submission) throws ATP_ExceptionHandler;
	public void DeleteSubmission(Submission submisson) throws ATP_ExceptionHandler;
	public Submission GetSubmissionByID(String submissionID) throws ATP_ExceptionHandler;
	public List<Submission> GetSubmissionByContestID(String contestID) throws ATP_ExceptionHandler;
	public List<Submission> GetSubmissionByProblemID(String problemID) throws ATP_ExceptionHandler;
	public List<Submission> GetSubmissionByStudentID(String studentID) throws ATP_ExceptionHandler;
	public List<Submission> GetSubmissionByStudent_ContestID(String studentID, String contestID) throws ATP_ExceptionHandler;
	public List<Submission> GetSubmissionByStudent_ProblemID(String StudentID, String problemID) throws ATP_ExceptionHandler;
	public List<Submission> GetAllSubmission() throws ATP_ExceptionHandler;
	
}
