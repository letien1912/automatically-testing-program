package dataAccess;

import javax.ejb.Remote;

import Entities.SubmissionResult;
import exceptionHandel.ExceptionHandeler;

@Remote
public interface I_SubmissionResultDAORemote {
	public SubmissionResult GetSubmissionResultBySubmissionID(String submissionID) throws ExceptionHandeler;
	public void CreateSubmission (SubmissionResult submissionResult) throws ExceptionHandeler;
	public void EditSubmissionResult (SubmissionResult submissionResult) throws ExceptionHandeler;
	public void DeleteSubmissionResult (SubmissionResult submissionResult) throws ExceptionHandeler;
}
