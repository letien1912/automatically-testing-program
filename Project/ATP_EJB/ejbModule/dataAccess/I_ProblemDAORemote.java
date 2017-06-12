package dataAccess;

import javax.ejb.Remote;

import Entities.Problem;
import exceptionHandl.ATP_ExceptionHandler;

@Remote
public interface I_ProblemDAORemote {
	//Problems
		public void CreateProblem(Problem problem) throws ATP_ExceptionHandler;
		public void EditProblem(Problem problem) throws ATP_ExceptionHandler;
		public void DeleteProblem(Problem problem) throws ATP_ExceptionHandler;
}
