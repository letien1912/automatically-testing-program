package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.Contest;
import exceptionHandl.ATP_ExceptionHandler;

@Remote
public interface I_ContestDAORemote {
	public void CreateContest(Contest contest) throws ATP_ExceptionHandler;
	public void DeleteContest(Contest contest) throws ATP_ExceptionHandler;
	public void EditContest (Contest contest) throws ATP_ExceptionHandler;
	public List<Contest> GetAllContest() throws  ATP_ExceptionHandler;
	public Contest GetContestByID(String contestID) throws ATP_ExceptionHandler;
}
