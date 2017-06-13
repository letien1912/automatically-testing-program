package CodeHandling;

import Entities.MarkingData;
import Entities.SubmissionResult;
import ErrorHandling.ProblemExceptionHandler;

public class SubmissionRefundator {
	MarkingData markingData = new MarkingData();
	ProblemCompiler problemCompiler = new ProblemCompiler(markingData);
	SubmissionResult result = new SubmissionResult();

	public SubmissionRefundator() {
		super();
	}

	public void execute() {

		try {
			problemCompiler.compile();
			if (isSuccessCompiled()) {
				ProblemComparator com = new ProblemComparator(problemCompiler.getCompiledURL(), markingData);
				com.compare();
			}
		} catch (ProblemExceptionHandler e) {
			e.printStackTrace();
		}

	}

	private boolean isSuccessCompiled() {

		if (problemCompiler.isCompileSusscess())
			return true;
		else {
			if (!problemCompiler.getProblemStatus().equals(ProblemStatus.DEFAULT)) {
				addSubmissionResultStatus();
			}
			return false;

		}
	}

	private void addSubmissionResultStatus() {
	}
}
