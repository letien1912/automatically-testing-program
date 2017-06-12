package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.NotAcceptOutput;
import exceptionHandl.ATP_ExceptionHandler;

@Remote
public interface I_NotAcceptOutputDAORemote {
	public void CreateNotAcceptOutput(NotAcceptOutput notAcceptOutput) throws ATP_ExceptionHandler;
	public List<NotAcceptOutput> GetAllNotAcceptOutputBySubmission(int submissionID) throws ATP_ExceptionHandler;
}
