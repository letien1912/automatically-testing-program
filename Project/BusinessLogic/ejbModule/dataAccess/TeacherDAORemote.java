package dataAccess;

import javax.ejb.Remote;

import Entities.Contest;
import Entities.Input;
import Entities.Output;
import Entities.Problem;
import Entities.Teacher;

@Remote
public interface TeacherDAORemote {
	public boolean EditTeacher(Teacher teacher);
	//Problems
	public boolean CreateProblem(Problem problem);
	public boolean EditProblem(Problem problem);
	public boolean DeleteProblem(Problem problem);
	//Contest
	public boolean CreateContest(Contest contest);
	public boolean EditContest(Contest contest);
	public boolean DeleteContest(Contest contest);
	//Input
	public boolean CreateInput(Input input);
	public boolean EditInput(Input input);
	public boolean DeleteInput(Input input);
	//Output
	public boolean CreateOutput(Output output);
	public boolean EditOutput(Output output);
	public boolean DeleteOutput(Output output);
}
