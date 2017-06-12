package dataAccess;

import javax.ejb.Remote;

import Entities.SubmissionResult;
import exceptionHandl.ATP_ExceptionHandler;

@Remote
public interface I_SubmissionResultDAORemote {
	public SubmissionResult GetSubmissionResultBySubmissionID(String submissionID) throws ATP_ExceptionHandler;
	public void CreateSubmission (SubmissionResult submissionResult) throws ATP_ExceptionHandler;
	public void EditSubmissionResult (SubmissionResult submissionResult) throws ATP_ExceptionHandler;
	public void DeleteSubmissionResult (SubmissionResult submissionResult) throws ATP_ExceptionHandler;
}
