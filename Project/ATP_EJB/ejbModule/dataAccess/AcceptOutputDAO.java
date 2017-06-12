package dataAccess;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.AcceptOutput;
import exceptionHandl.ATP_ExceptionHandler;

/**
 * Session Bean implementation class AcceptOutputDAO
 */
@Stateless
@LocalBean
public class AcceptOutputDAO implements I_AcceptOutputDAORemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="Entities")
	private EntityManager em;
    public AcceptOutputDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void CreateAcceptOutput(AcceptOutput acceptOutput) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(acceptOutput);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 34, "AcceptOutputDAO", "Create AcceptOutput Fail");
		}
	}

	@Override
	public List<AcceptOutput> GetAllAcceptOutputBySubmission(int submissionID) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			return em.createNamedQuery("AcceptOutput.GetAllBySubmission",AcceptOutput.class)
			.setParameter("submissionID", submissionID)
			.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 46, "AcceptOutputDAO", "Get All AcceptOutput by Submission Fail");
		}
	}

}
