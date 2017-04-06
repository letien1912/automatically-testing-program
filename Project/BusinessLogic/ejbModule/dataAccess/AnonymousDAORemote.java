package dataAccess;

import java.util.List;

import javax.ejb.Remote;

import Entities.Contest;
import Entities.Problem;
import Entities.Student;
import Entities.Submission;

@Remote
public interface AnonymousDAORemote {
	//Student Data Access
	public Student GetStudentByID(String studentID);
	public boolean CreateStudent(Student st);
	//Contest Data Access
	public List<Contest> GetAllContests();
	public Contest GetContestByID(String contestID);
	public List<Contest> FindContestByName(String contestName);
	public List<Contest> GetListContestByUserID(String userID);
	//Problem Data Access
	public List<Problem> GetAllProblems();
	public List<Problem> GetListProblemByContestID(String contestID);
	public Problem GetProblemByID(String ProblemID);
	public List<Problem> FindProblemByName(String problemName);
	//Submission Data Access
	public List<Submission> GetAllSubmission();
	public List<Submission> GetListSubmissionByUserID(String userID);
	public List<Submission> GetListSubmissionBYContestID(String contestID);
	public Submission GetSubmissionByID(String SubmissionID);
}
