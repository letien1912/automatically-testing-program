package dataAccess;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import Entities.AcceptOutput;
import Entities.NotAcceptOutput;
import Entities.Student_ContestDetail;
import Entities.Submission;
import Entities.SubmissionResult;

/**
 * =================== [NOTE 06-04-2017] ====================
 * =================== Not completed ========================
 */
/**
 * Session Bean implementation class SystemDAO
 */
@Stateless
@LocalBean
public class SystemDAO implements SystemDAORemote {

    /**
     * Default constructor. 
     */
    public SystemDAO() {
        // TODO Auto-generated constructor stub
    	
    }

	@Override
	public boolean CreateSubmission(Submission submission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CreateSubmissionResult(SubmissionResult submissionResult) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CreateAccepteOutput(AcceptOutput acceptOutput) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CreateNotAcceptOutput(NotAcceptOutput notAcceptOutput) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CreateStudent_ContestDetail(Student_ContestDetail student_ContestDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean EditStudent_ContestDetail(Student_ContestDetail student_ContestDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteStudent_ContestDetail(Student_ContestDetail student_ContestDetail) {
		// TODO Auto-generated method stub
		return false;
	}

}
