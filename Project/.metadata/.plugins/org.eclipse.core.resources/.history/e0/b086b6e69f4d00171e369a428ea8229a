package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.Input;
import exceptionHandel.ExceptionHandeler;

@Remote
public interface I_InputDAORemote {
	public void CreateInput(Input input) throws ExceptionHandeler;
	public void DeleteInput(Input input) throws ExceptionHandeler;
	public void EditInput(Input input) throws ExceptionHandeler;
	public Input GetInput(int inputID) throws ExceptionHandeler;
	public List<Input> GetInputByProblemID(String problemID) throws ExceptionHandeler;
}
