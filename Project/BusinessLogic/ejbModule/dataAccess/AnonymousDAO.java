package dataAccess;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Contest;
import Entities.Problem;
import Entities.Student;
import Entities.Submission;

/**
 * =================== [NOTE 06-04-2017] ====================
 * =================== Not completed ========================
 */
/**
 * Session Bean implementation class AnonymousDAO
 */
@Stateless
@LocalBean
public class AnonymousDAO implements AnonymousDAORemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="Entities")
	private EntityManager em;
    public AnonymousDAO() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public boolean CreateStudent(Student st) {
		// TODO Auto-generated method stub
		try{
			em.persist(st);
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	@Override
	public Student GetStudentByID(String studentID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Contest> GetAllContests() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Contest GetContestByID(String contestID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Contest> FindContestByName(String contestName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Contest> GetListContestByUserID(String userID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Problem> GetAllProblems() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Problem> GetListProblemByContestID(String contestID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Problem GetProblemByID(String ProblemID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Problem> FindProblemByName(String problemName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Submission> GetAllSubmission() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Submission> GetListSubmissionByUserID(String userID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Submission> GetListSubmissionBYContestID(String contestID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Submission GetSubmissionByID(String SubmissionID) {
		// TODO Auto-generated method stub
		return null;
	}

}
