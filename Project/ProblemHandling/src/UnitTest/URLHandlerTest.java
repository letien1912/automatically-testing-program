package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ErrorHandling.ProblemExceptionHandler;
import Utilities.URLHandler;

public class URLHandlerTest {

	@Test
	public void testWriteFile() throws ProblemExceptionHandler {
		String expected = "CodeFolder"  + "/" + "xxx" + ".cpp";
		String actualURL = URLHandler.writeFile("abc", "xxx");
		assertEquals(expected, actualURL);
	}

}
