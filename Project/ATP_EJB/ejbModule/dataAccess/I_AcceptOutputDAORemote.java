package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.AcceptOutput;
import exceptionHandl.ATP_ExceptionHandler;

@Remote
public interface I_AcceptOutputDAORemote {
	public void CreateAcceptOutput(AcceptOutput acceptOutput) throws ATP_ExceptionHandler;
	public List<AcceptOutput> GetAllAcceptOutputBySubmission(int submissionID) throws ATP_ExceptionHandler;
}
