package CodeHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Entities.Submission;
import ErrorHandling.ProblemHandlingException;
import ErrorHandling.ProblemHandlingException.ErrorCode;
import Utilities.URLHandler;

public class ProblemCompiler {
	private Submission submission;
	private String fileContainer;
	private boolean isCompileSusscess;
	private String errorCompileContain;
	
	public ProblemCompiler(Submission submission) {
		super();
		this.submission = submission;
	}

	public void compile() throws ProblemHandlingException {
		String problemName = submission.getSubmissionId();
		fileContainer = URLHandler.writeFile(submission.getSourceCode(), problemName);
		try {
			Process process = new ProcessBuilder("g++", fileContainer, "-o", problemName).start();
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			errorCompileContain = getErrorCompile(stdError);
			if(isErrorContainEmpty(errorCompileContain))
				isCompileSusscess = true;
			else 
				isCompileSusscess = false;

		} catch (IOException e) {
			throw new ProblemHandlingException(ErrorCode.COMPILER_ERROR, e.getMessage());
		}
	}
	
	private boolean isErrorContainEmpty(String errorContain) {
		return errorContain.equals("");
	}

	private String getErrorCompile(BufferedReader stdError) throws IOException {
		String error = null;
		String errorCompile = "";
		while ((error = stdError.readLine()) != null) {
			errorCompile += error + "\n";
		}
		stdError.close();
		return errorCompile;
	}
	
	public String getCompiledURL() throws ProblemHandlingException {
		if (isCompileSusscess)
			return URLHandler.getCompiledURL(submission.getSubmissionId());
		throw new ProblemHandlingException(ErrorCode.COMPILE_UNSUCCESS, getErrorCompileContain());
	}

	public boolean isCompileSusscess() {
		return isCompileSusscess;
	}
	
	public String getErrorCompileContain() {
		if (!isCompileSusscess) {
			return errorCompileContain;
		}
		return "";
	}

}
