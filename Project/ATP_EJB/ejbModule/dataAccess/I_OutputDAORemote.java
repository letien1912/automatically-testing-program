package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.Output;
import exceptionHandl.ATP_ExceptionHandler;

@Remote
public interface I_OutputDAORemote {
	public void CreateOutput(Output output) throws ATP_ExceptionHandler;
	public void EditOutput(Output output) throws ATP_ExceptionHandler;
	public void DeleteOutput(Output output) throws ATP_ExceptionHandler;
	public Output GetOutput(int outputID, String problemID) throws ATP_ExceptionHandler;
	public List<Output> GetOutputByProblemID(String problemID) throws ATP_ExceptionHandler;
}
