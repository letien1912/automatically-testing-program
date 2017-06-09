package CodeHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import Entities.Input;
import Entities.Output;
import Entities.Problem;
import Entities.Submission;
import ErrorHandling.ProblemHandlingException;
import ErrorHandling.ProblemHandlingException.ErrorCode;

public class ProblemComparator {

	private static int NUMBER_OF_THREAD_DEFAULT = 20;

	private Submission submission;
	private Problem problem;

	private List<Input> inputs;
	private List<Output> outputs;
	private Process process;

	private ThreadPoolExecutor executor;

	public ProblemComparator(String compiledURL, Submission submission) throws ProblemHandlingException {
		super();
		try {
			process = new ProcessBuilder(compiledURL).start();
		} catch (IOException e) {
			throw new ProblemHandlingException(ErrorCode.FILE_NOT_FOUND, e.getMessage() + "");
		}
		this.submission = submission;
		init();
	}

	private void init() throws ProblemHandlingException {
		inputs = getAllInput(submission.getProblemId());
		outputs = getAllOutput(submission.getProblemId());
		if (isInputEmpty())
			throw new ProblemHandlingException(ErrorCode.NO_DATA, "inputs");
		if (isOutputEmpty())
			throw new ProblemHandlingException(ErrorCode.NO_DATA, "outputs");

		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(NUMBER_OF_THREAD_DEFAULT);
	}

	private List<Input> getAllInput(String problemId) {
		return null;
	}

	private List<Output> getAllOutput(String problemId) {
		return null;
	}

	private boolean isInputEmpty() {
		return inputs.size() == 0;
	}

	private boolean isOutputEmpty() {
		return outputs.size() == 0;
	}

	public void compare() throws ProblemHandlingException {
		if (!areInputAndOutputSameSize())
			throw new ProblemHandlingException(ErrorCode.INPUT_OUTPUT_DIFFERENT);
		int numberTestcase = inputs.size();
		for (int i = 0; i < numberTestcase; ++i) {
			if (!acceptPerTest(i)) {
				return;
			}
		}
	}

	private boolean areInputAndOutputSameSize() {
		return inputs.size() == outputs.size();
	}

	private boolean acceptPerTest(int pos) {
		Output output = outputs.get(pos);
		String actualOutput = getActualOutput();
		return output.getOutputTest().equals(actualOutput);
	}

	private String getActualOutput() {
		Future<String> futureActualOutput = executor.submit(new ActualOutputTask(process));
		String actualOutput = "";
		try {
			actualOutput = futureActualOutput.get((long) problem.getTimeLimit(), TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			/*Time limit*/
			stopFindActualOutput(futureActualOutput);
			e.printStackTrace();
		}
		stopThreadpool();
		if(isActualOutputEmpty(actualOutput))
			/*Lam gi do*/;
		return actualOutput;
	}

	private boolean isActualOutputEmpty(String output) {
		return output.equals("");
	}

	private void stopFindActualOutput(Future<String> futureActualOutput) {
		futureActualOutput.cancel(true);
	}
	
	private void stopThreadpool() {
		executor.shutdown();
	}
	

	/*-----------CLASS--------*/
	class ActualOutputTask implements Callable<String> {
		private Process process;

		public ActualOutputTask(Process process) {
			this.process = process;
		}

		@Override
		public String call() throws Exception {
			return getActualResult(process);
		}
	}

	private String getActualResult(Process process) {
		String answer = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				answer += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return answer;
	}

}