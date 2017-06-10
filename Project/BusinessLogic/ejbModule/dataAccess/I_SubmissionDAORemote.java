package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.Submission;
import exceptionHandel.ExceptionHandeler;

@Remote
public interface I_SubmissionDAORemote {
	public void CreateSubmission(Submission submission) throws ExceptionHandeler;
	public void DeleteSubmission(Submission submisson) throws ExceptionHandeler;
	public Submission GetSubmissionByID(String submissionID) throws ExceptionHandeler;
	public List<Submission> GetSubmissionByContestID(String contestID) throws ExceptionHandeler;
	public List<Submission> GetSubmissionByProblemID(String problemID) throws ExceptionHandeler;
	public List<Submission> GetSubmissionByStudentID(String studentID) throws ExceptionHandeler;
	public List<Submission> GetSubmissionByStudent_ContestID(String studentID, String contestID) throws ExceptionHandeler;
	public List<Submission> GetSubmissionByStudent_ProblemID(String StudentID, String problemID) throws ExceptionHandeler;
	public List<Submission> GetAllSubmission() throws ExceptionHandeler;
	
}
