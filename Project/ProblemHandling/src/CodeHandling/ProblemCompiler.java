package CodeHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Entities.MarkingData;
import Entities.Submission;
import ErrorHandling.ProblemExceptionHandler;
import ErrorHandling.ProblemExceptionHandler.ErrorCode;
import Utilities.URLHandler;

public class ProblemCompiler {
	private MarkingData markingData;
	private String fileContainer;
	private boolean isCompileSusscess;
	private String errorCompileContain;
	private ProblemStatus problemStatus = ProblemStatus.DEFAULT;
	public ProblemCompiler(MarkingData markingData) {
		super();
		this.markingData = markingData;
	}

	public void compile() throws ProblemExceptionHandler {
		fileContainer = URLHandler.writeFile(markingData.getSourceCode(), markingData.getSubmissionID()+"");
		String problemName = URLHandler.getCompliedFolder(markingData.getSubmissionID()+"");
		
		System.out.println(fileContainer);
		try {
			Process process = new ProcessBuilder("g++", fileContainer, "-o", problemName).start();
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			errorCompileContain = getErrorCompile(stdError);
			if(isErrorContainEmpty(errorCompileContain))
				isCompileSusscess = true;
			else 
				isCompileSusscess = false;

		} catch (IOException e) {
			throw new ProblemExceptionHandler(ErrorCode.COMPILER_ERROR, e.getMessage());
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
	
	public String getCompiledURL() throws ProblemExceptionHandler {
		if (isCompileSusscess)
			return URLHandler.getCompiledFile(markingData.getSubmissionID()+"");
		throw new ProblemExceptionHandler(ErrorCode.COMPILE_UNSUCCESS, getErrorCompileContain());
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
	
	public ProblemStatus getProblemStatus() {
		return problemStatus;
	}

}
