package dataAccess;

import javax.ejb.Remote;

import Entities.AcceptOutput;
import Entities.NotAcceptOutput;
import Entities.Student_ContestDetail;
import Entities.Submission;
import Entities.SubmissionResult;

@Remote
public interface SystemDAORemote {
	public boolean CreateSubmission(Submission submission);
	public boolean CreateSubmissionResult(SubmissionResult submissionResult);
	public boolean CreateAccepteOutput(AcceptOutput acceptOutput);
	public boolean CreateNotAcceptOutput(NotAcceptOutput notAcceptOutput);
	public boolean CreateStudent_ContestDetail(Student_ContestDetail student_ContestDetail);
	public boolean EditStudent_ContestDetail(Student_ContestDetail student_ContestDetail);
	public boolean DeleteStudent_ContestDetail(Student_ContestDetail student_ContestDetail);
	
}
