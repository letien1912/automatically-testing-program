package CodeHandling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import Entities.AcceptOutput;
import Entities.Input;
import Entities.Output;
import Entities.MarkingData;
import Entities.NotAcceptOutput;
import ErrorHandling.ProblemExceptionHandler;
import ErrorHandling.ProblemExceptionHandler.ErrorCode;

public class ProblemComparator {

	private static int NUMBER_OF_THREAD_DEFAULT = 20;

	private MarkingData markingData;

	private List<Input> inputs;
	private List<Output> outputs;
	private List<AcceptOutput> acceptOutputs;
	private List<NotAcceptOutput> notAcceptOutputs;

	private Process process;

	private ThreadPoolExecutor executor;

	private ProblemStatus problemStatus = ProblemStatus.DEFAULT;

	private String compiledURL;

	public ProblemComparator(String compiledURL, MarkingData markingData) throws ProblemExceptionHandler {
		super();
		this.markingData = markingData;
		this.compiledURL = compiledURL;
		init();
	}

	private void init() throws ProblemExceptionHandler {
		inputs = markingData.getListInput();
		outputs = markingData.getListOutput();

		notAcceptOutputs = new ArrayList<>();
		acceptOutputs = new ArrayList<>();

		if (isInputEmpty())
			throw new ProblemExceptionHandler(ErrorCode.NO_DATA, "inputs");
		if (isOutputEmpty())
			throw new ProblemExceptionHandler(ErrorCode.NO_DATA, "outputs");

	}

	private boolean isInputEmpty() {
		return inputs.size() == 0;
	}

	private boolean isOutputEmpty() {
		return outputs.size() == 0;
	}

	public void compare() throws ProblemExceptionHandler {
		if (!areInputAndOutputSameSize())
			throw new ProblemExceptionHandler(ErrorCode.INPUT_OUTPUT_DIFFERENT);
		int numberTestcase = inputs.size();
		for (int i = 0; i < numberTestcase; ++i) {
			writeInput(inputs.get(i));
			if (!isProblemStatusDefault()) {
				if (!acceptPerTest(i)) {
					problemStatus = ProblemStatus.WRONG_ANSWER;
				} else {

				}
			}
		}
		if (isProblemStatusDefault())
			problemStatus = ProblemStatus.ACCEPT;
	}

	private void writeInput(Input input) throws ProblemExceptionHandler {
		rebuildFile();
		Future<Boolean> futureWriteInput = executor.submit(new WriteInputTask(process, input));
		try {
			futureWriteInput.get((long) markingData.getTimeLimit(), TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		} catch (ExecutionException e) {
			System.out.println("ExecutionException");
			e.printStackTrace();
		} catch (TimeoutException e) {
			problemStatus = ProblemStatus.RUNTIME_ERROR;
			futureWriteInput.cancel(true);
		}
	}

	private void rebuildFile() throws ProblemExceptionHandler {
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(NUMBER_OF_THREAD_DEFAULT);
		try {
			process = new ProcessBuilder(compiledURL).start();
		} catch (IOException e) {
			throw new ProblemExceptionHandler(ErrorCode.FILE_NOT_FOUND, e.getMessage() + "");
		}
	}

	private boolean areInputAndOutputSameSize() {
		return inputs.size() == outputs.size();
	}

	private boolean acceptPerTest(int pos) {
		Output output = outputs.get(pos);
		String actualOutput = getActualOutput();
		/*
		 * System.out.println("output = " + output.getOutputData());
		 * System.out.println("actualOutput = " + actualOutput);
		 */
		boolean res = output.getOutputData().equals(actualOutput);
		addAcceptResult(res, pos);
		return res;
	}

	private String getActualOutput() {
		Future<String> futureActualOutput = executor.submit(new ActualOutputTask(process));
		String actualOutput = "";
		try {
			actualOutput = futureActualOutput.get((long) markingData.getTimeLimit(), TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			/* Time limit */
			problemStatus = ProblemStatus.TIME_LIMIT;
			stopProcess(futureActualOutput);
		}
		stopThreadpool();
		if (isActualOutputEmpty(actualOutput))
			/* Lam gi do */;
		return actualOutput;
	}

	private void stopProcess(Future<String> futureActualOutput) {
		if (process.isAlive())
			process.destroy();
		futureActualOutput.cancel(true);
	}

	private void stopThreadpool() {
		executor.shutdownNow();
	}

	private boolean isActualOutputEmpty(String output) {
		return output.equals("");
	}

	private void addAcceptResult(Boolean res, int pos) {
		if (res) {
			AcceptOutput accept = new AcceptOutput();
			accept.setInputIndex(pos);
			accept.setStudentOutput(getActualOutput());
			accept.setTeacherOutput(outputs.get(pos).getOutputData());
			accept.setSubmissionId(markingData.getSubmissionID());
			acceptOutputs.add(accept);
		} else {
			NotAcceptOutput notAccept = new NotAcceptOutput();
			notAccept.setInputIndex(pos);
			notAccept.setStudentOutput(getActualOutput());
			notAccept.setTeacherOutput(outputs.get(pos).getOutputData());
			notAccept.setSubmissionId(markingData.getSubmissionID());
			notAcceptOutputs.add(notAccept);
		}
	}

	private boolean isProblemStatusDefault() {
		return problemStatus.equals(ProblemStatus.DEFAULT);
	}

	public ProblemStatus getProblemStatus() {
		return problemStatus;
	}

	public List<AcceptOutput> getAcceptOutputs() {
		return acceptOutputs;
	}

	public List<NotAcceptOutput> getNotAcceptOutputs() {
		return notAcceptOutputs;
	}

}
