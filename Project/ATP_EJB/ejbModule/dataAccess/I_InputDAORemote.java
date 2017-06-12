package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.Input;
import exceptionHandl.ATP_ExceptionHandler;

@Remote
public interface I_InputDAORemote {
	public void CreateInput(Input input) throws ATP_ExceptionHandler;
	public void DeleteInput(Input input) throws ATP_ExceptionHandler;
	public void EditInput(Input input) throws ATP_ExceptionHandler;
	public Input GetInput(int inputID, String problemID) throws ATP_ExceptionHandler;
	public List<Input> GetInputByProblemID(String problemID) throws ATP_ExceptionHandler;
}
