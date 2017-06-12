package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.Output;
import exceptionHandel.ExceptionHandeler;

@Remote
public interface I_OutputDAORemote {
	public void CreateOutput(Output output) throws ExceptionHandeler;
	public void EditOutput(Output output) throws ExceptionHandeler;
	public void DeleteOutput(Output output) throws ExceptionHandeler;
	public Output GetOutput(int outputID, String problemID) throws ExceptionHandeler;
	public List<Output> GetOutputByProblemID(String problemID) throws ExceptionHandeler;
}
