package Utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.*;

public class CompareProblemAnswer {
	public static String ProblemUrl = "Problem";
	private static String InputUrl = "Input";
	private static String OutputUrl = "Output";
	private static String EXE = ".exe";
	private static int DEFAULT_TIME_LIMIT_MILISECONDS = 1000;
	private static int MAX_NUMBER_THREAD = 20;
	private int lengthOfTestCase = 0;
	private int numberCorrectTest = 0;
	private String problemCodeName;
	private String testcaseNumber;
	private Process process;
	private int TimeLimit;
	private int RunTimeLimit;

	public int getTimeLimit() {
		return TimeLimit;
	}

	public void setTimeLimit(int timeLimitMilisecond) {
		TimeLimit = timeLimitMilisecond;
	}

	public int getRunTimeLimit() {
		return RunTimeLimit;
	}

	public void setRunTimeLimit(int runTimeLimitMiliseconds) {
		RunTimeLimit = runTimeLimitMiliseconds;
	}

	public CompareProblemAnswer(String problemCodeName) {
		super();
		this.problemCodeName = problemCodeName;
	}

	public void compare() {
		/* Read All file in folder */
		File folder = new File("Input");
		File[] listOfFiles = folder.listFiles();
		lengthOfTestCase = listOfFiles.length;
		for (File file : listOfFiles) {
			if (file.isFile()) {
				String fileName = file.getName();
				boolean result = CompareOutputPerTestCase(fileName, problemCodeName);
				if (result)
					++numberCorrectTest;
			}
		}
	}

	public int getLengthOfTestCase() {
		return lengthOfTestCase;
	}

	public int getNumberCorrectTest() {
		return numberCorrectTest;
	}

	private boolean CompareOutputPerTestCase(String testcaseNumber, String problemCodeName) {
		this.testcaseNumber = testcaseNumber;
		TimeLimit = DEFAULT_TIME_LIMIT_MILISECONDS;
		RunTimeLimit = DEFAULT_TIME_LIMIT_MILISECONDS;

		String output = ReadAnswer(testcaseNumber);
		String answer = "";
		/* Start builded file */
		try {
			process = new ProcessBuilder(problemCodeName + EXE).start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(MAX_NUMBER_THREAD);
		Future<Boolean> futureWriteInput = executor.submit(new WriteInputTask());
		System.out.println("count many executor is running "  + executor.getMaximumPoolSize());

		Boolean isNotRuntimeError = false;
		try {
			System.out.println("----- Writing input ----");
			isNotRuntimeError = futureWriteInput.get(RunTimeLimit, TimeUnit.MILLISECONDS);
			System.out.println("----- Success Write input ----");
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		} catch (ExecutionException e) {
			System.out.println("ExecutionException");
			e.printStackTrace();
		} catch (TimeoutException e) {
			futureWriteInput.cancel(true);
			System.out.println("----- Runtime Error ----");
		}

		/* check if not found runtime error */
		Future<String> futureAnswer = executor.submit(new GetAnswerTask());
		if (isNotRuntimeError) {
			System.out.println("----- Reading Output ----");
			try {
				answer = futureAnswer.get(TimeLimit, TimeUnit.MILLISECONDS);
				System.out.println("----- Success get answer ----");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				futureWriteInput.cancel(true);
				System.out.println("===== Time Limit =====");
			}
		}
		executor.shutdownNow();
		if (answer.equals(""))
			System.out.println("===== No Output was Found =====");
		
		System.out.println();

		return output.equals(answer);
	}

	private String ReadInput(String testcaseNumber) {
		String input = "";
		BufferedReader readTest;
		try {
			readTest = new BufferedReader(new FileReader(InputUrl + "/" + testcaseNumber));
			String line = "";
			while ((line = readTest.readLine()) != null) {
				input += line;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	private String ReadAnswer(String testcaseNumber) {
		String output = "";
		BufferedReader readTest;
		try {
			readTest = new BufferedReader(new FileReader(OutputUrl + "/" + testcaseNumber));
			String line = "";
			while ((line = readTest.readLine()) != null) {
				output += line;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}

	class WriteInputTask implements Callable<Boolean> {
		@Override
		public Boolean call() throws Exception {
			return WriteInputTest(process);
		}
	}

	class GetAnswerTask implements Callable<String> {
		@Override
		public String call() throws Exception {
			return GetAnswerTest(process);
		}
	}

	private boolean WriteInputTest(Process process) {
		BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
		try {
			String input = ReadInput(testcaseNumber);
			bW.write(input);
			bW.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				bW.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	private String GetAnswerTest(Process process) {
		String answer = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				answer += line;
			}
			/* some thing else */
			/*
			 * int waitFlag = -1 ; try { waitFlag = process.waitFor(); } catch
			 * (InterruptedException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }// Wait to finish application // execution.
			 * if (waitFlag == 0) { int returnVal = process.exitValue(); }
			 */
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// check time limit
//		long startTime = System.currentTimeMillis();
//		long endTime   = System.currentTimeMillis();
//		long totalTime = endTime - startTime;
//		System.out.println("Time run = " + totalTime);
		return answer;
	}
}
