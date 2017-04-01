package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompileProblemAnswer {
	private boolean isCompiledSuccess;
	private String errorCompile = "";
	private String problemCodeUrl;
	
	public CompileProblemAnswer(String problemCodeName) {
		super();
		this.problemCodeUrl = problemCodeName;
	}

	@SuppressWarnings("unused")
	public void start() { // problemCodeFile = Cfolder/test.cpp
		Process buildprocess;
		try {
			buildprocess = new ProcessBuilder("g++", problemCodeUrl + ".cpp", "-o", problemCodeUrl).start();
			BufferedReader stdError = new BufferedReader(new InputStreamReader(buildprocess.getErrorStream()));
			String error = null;
			while ((error = stdError.readLine()) != null) {
				errorCompile += error + "\n";
			}
			if(errorCompile.equals(""))
				isCompiledSuccess = true;
			else
				isCompiledSuccess = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isCompiledSuccess() {
		return isCompiledSuccess;
	}

	public String getErrorCompile() {
		return errorCompile;
	}

}
