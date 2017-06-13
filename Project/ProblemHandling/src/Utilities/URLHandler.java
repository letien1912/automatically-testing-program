package Utilities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import ErrorHandling.ProblemExceptionHandler;
import ErrorHandling.ProblemExceptionHandler.ErrorCode;

public class URLHandler {
	private static final String CODE_URL = "CodeFolder"; 
	private static final String CODE_SUFFIX = ".cpp";
	public static final String CODE_SUFFIX_COMPILED = ".exe";
	
	public static String writeFile(String content, String name) throws ProblemExceptionHandler{
		String url = CODE_URL  + "/" + name + CODE_SUFFIX;
		writeCodeToUrl(content, url);
		return url;
	}
	
	public static String getCompiledFile(String name){
		return CODE_URL + "/" + name + CODE_SUFFIX_COMPILED;
	}
	
	public static String getCompliedFolder(String name){
		return CODE_URL + "/" + name;
	}

	private static void writeCodeToUrl(String content, String url) throws ProblemExceptionHandler {
		PrintWriter out;
		try {
			out = new PrintWriter(url);
			out.print(content);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// need handler
			throw new ProblemExceptionHandler(ErrorCode.FILE_NOT_FOUND, e.getMessage());
		}
		
	}
}
