package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import CodeHandling.ProblemCompiler;
import Entities.MarkingData;
import ErrorHandling.ProblemExceptionHandler;
import ErrorHandling.ProblemExceptionHandler.ErrorCode;

public class ProblemCompilerTest {

	@Test
	public void testCompileErrorWithNoError() throws ProblemExceptionHandler {
		MarkingData sub = new MarkingData();
		sub.setSubmissionID(1);
		sub.setSourceCode(
				"#include <iostream> \n #include <algorithm> \n using namespace std;int a[3];int main() { cin >> a[0] >> a[1] >> a[2];sort(a, a + 3);cout<<(a[1]-a[0])+(a[2]-a[1]);}");
		ProblemCompiler compiler = new ProblemCompiler(sub);
		compiler.compile();
		assertEquals(compiler.getErrorCompileContain(), "");
	}

	@Test
	public void testCompileErrorWithError() throws ProblemExceptionHandler {
		MarkingData sub = new MarkingData();
		sub.setSubmissionID(1);
		sub.setSourceCode(
				"#include <iostream>  #include <algorithm>  using namespace std;int a[3];int main() { cin >> a[0] >> a[1] >> a[2];sort(a, a + 3);cout<<(a[1]-a[0])+(a[2]-a[1]);}");
		ProblemCompiler compiler = new ProblemCompiler(sub);
		compiler.compile();
		try {
			compiler.getCompiledURL();
		} catch (ProblemExceptionHandler e) {
			assertEquals(e.getErrorCode(), ErrorCode.COMPILE_UNSUCCESS);
			assertEquals(e.getErrorParam(), compiler.getErrorCompileContain());
		}
	}

	@Test
	public void testCompileSuccess() throws ProblemExceptionHandler {
		Boolean expect = true;

		MarkingData sub = new MarkingData();
		sub.setSubmissionID(2);
		sub.setSourceCode(
				"#include <iostream> \n#include <algorithm>\nusing namespace std;int a[3];int main() { cin >> a[0] >> a[1] >> a[2];sort(a, a + 3);cout<<(a[1]-a[0])+(a[2]-a[1]);}");
		ProblemCompiler compiler = new ProblemCompiler(sub);
		compiler.compile();
		assertEquals(compiler.isCompileSusscess(), expect);
	}

	@Test
	public void testNoCompile() throws ProblemExceptionHandler {
		MarkingData sub = new MarkingData();
		sub.setSubmissionID(1);
		sub.setSourceCode(
				"#include <iostream> #include <algorithm> \n using namespace std;int a[3];int main() { cin >> a[0] >> a[1] >> a[2];sort(a, a + 3);cout<<(a[1]-a[0])+(a[2]-a[1]);}");
		ProblemCompiler compiler = new ProblemCompiler(sub);

		try {
			compiler.getCompiledURL();
		} catch (ProblemExceptionHandler e) {
			assertEquals(e.getErrorCode(), ErrorCode.COMPILE_UNSUCCESS);
			assertEquals(e.getErrorParam(), compiler.getErrorCompileContain());
		}

	}

	@Test
	public void testTimeLimitCode() throws ProblemExceptionHandler {
		Boolean expect = true;
		MarkingData sub = new MarkingData();
		sub.setSubmissionID(3);
		sub.setSourceCode(
				"#include <iostream> \n#include <algorithm>\nusing namespace std;int a[3];int main() { cin >> a[0] >> a[1] >> a[2];sort(a, a + 3);while(true);cout<<(a[1]-a[0])+(a[2]-a[1]);}");
		ProblemCompiler compiler = new ProblemCompiler(sub);
		compiler.compile();
		assertEquals(compiler.isCompileSusscess(), expect);
	}

	@Test
	public void testMemorylimitCode() throws ProblemExceptionHandler {
		Boolean expect = true;
		MarkingData sub = new MarkingData();
		sub.setSubmissionID(4);
		sub.setSourceCode(
				"#include <iostream> \n#include <algorithm>\nusing namespace std;int a[100000];int main() { int b[60000000];cin >> a[0] >> a[1] >> a[2];sort(a, a + 3);while(true);cout<<(a[1]-a[0])+(a[2]-a[1]);}");
		ProblemCompiler compiler = new ProblemCompiler(sub);
		compiler.compile();
		assertEquals(compiler.isCompileSusscess(), expect);
	}

}
