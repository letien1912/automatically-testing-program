package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.IOP.Codec;

import CodeHandling.ProblemCompiler;
import Entities.Submission;
import ErrorHandling.ProblemHandlingException;
import ErrorHandling.ProblemHandlingException.ErrorCode;

public class ProblemCompilerTest {


	@Test
	public void testCompileErrorWithNoError() throws ProblemHandlingException {
		Submission sub = new Submission();
		sub.setSubmissionId("1");
		sub.setSourceCode(
				"#include <iostream> \n #include <algorithm> \n using namespace std;int a[3];int main() { cin >> a[0] >> a[1] >> a[2];sort(a, a + 3);cout<<(a[1]-a[0])+(a[2]-a[1]);}");
		ProblemCompiler compiler = new ProblemCompiler(sub);
		compiler.compile();
		assertEquals(compiler.getErrorCompileContain(), "");
	}

	@Test
	public void testCompileErrorWithError() throws ProblemHandlingException {
		Submission sub = new Submission();
		sub.setSubmissionId("1");
		sub.setSourceCode(
				"#include <iostream>  #include <algorithm>  using namespace std;int a[3];int main() { cin >> a[0] >> a[1] >> a[2];sort(a, a + 3);cout<<(a[1]-a[0])+(a[2]-a[1]);}");
		ProblemCompiler compiler = new ProblemCompiler(sub);
		compiler.compile();
		try {
			compiler.getCompiledURL();
		} catch (ProblemHandlingException e) {
			assertEquals(e.getErrorCode(), ErrorCode.COMPILE_UNSUCCESS);
			assertEquals(e.getErrorParam(), compiler.getErrorCompileContain());
		}
	}
	
	@Test
	public void testCompileSuccess() throws ProblemHandlingException {
		Boolean expect = true;
		
		Submission sub = new Submission();
		sub.setSubmissionId("1");
		sub.setSourceCode(
				"#include <iostream> \n #include <algorithm> \n using namespace std;int a[3];int main() { cin >> a[0] >> a[1] >> a[2];sort(a, a + 3);cout<<(a[1]-a[0])+(a[2]-a[1]);}");
		ProblemCompiler compiler = new ProblemCompiler(sub);
		compiler.compile();
		assertEquals(compiler.isCompileSusscess(), expect);
	}
	
	@Test
	public void testNoCompile() throws ProblemHandlingException {
		Submission sub = new Submission();
		sub.setSubmissionId("1");
		sub.setSourceCode(
				"#include <iostream> #include <algorithm> \n using namespace std;int a[3];int main() { cin >> a[0] >> a[1] >> a[2];sort(a, a + 3);cout<<(a[1]-a[0])+(a[2]-a[1]);}");
		ProblemCompiler compiler = new ProblemCompiler(sub);

		try {
			compiler.getCompiledURL();
		} catch (ProblemHandlingException e) {
			assertEquals(e.getErrorCode(), ErrorCode.COMPILE_UNSUCCESS);
			assertEquals(e.getErrorParam(), compiler.getErrorCompileContain());
		}
	}



}
