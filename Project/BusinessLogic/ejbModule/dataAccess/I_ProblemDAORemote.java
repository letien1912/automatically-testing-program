package dataAccess;

import javax.ejb.Remote;

import Entities.Problem;
import exceptionHandel.ExceptionHandeler;

@Remote
public interface I_ProblemDAORemote {
	//Problems
		public void CreateProblem(Problem problem) throws ExceptionHandeler;
		public void EditProblem(Problem problem) throws ExceptionHandeler;
		public void DeleteProblem(Problem problem) throws ExceptionHandeler;
}
