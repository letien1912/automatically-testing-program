package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ErrorHandling.ProblemHandlingException;
import Utilities.URLHandler;

public class URLHandlerTest {

	@Test
	public void testWriteFile() throws ProblemHandlingException {
		String expected = "CodeFolder"  + "/" + "xxx" + ".cpp";
		String actualURL = URLHandler.writeFile("abc", "xxx");
		assertEquals(expected, actualURL);
	}

}
