package UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import CodeHandling.ProblemComparator;
import CodeHandling.ProblemStatus;
import Entities.Input;
import Entities.MarkingData;
import Entities.Output;
import ErrorHandling.ProblemExceptionHandler;

public class ProblemComparatorTest {
	
	@Test
	public void testAccept() throws ProblemExceptionHandler {
		MarkingData m = new MarkingData();
		m.setListInput(addInput());
		m.setListOutput(addOutput());
		m.setTimeLimit(2000f);
		ProblemComparator comparator = new ProblemComparator("CodeFolder/2.exe", m);
		comparator.compare();
		
		ProblemStatus actual = ProblemStatus.ACCEPT;
		assertEquals(comparator.getProblemStatus(), actual);
	}
	
	@Test
	public void testRunTimeError() throws ProblemExceptionHandler {
		MarkingData m = new MarkingData();
		
		m.setListInput(addInputRuntime());
		m.setListOutput(addOutput());
		m.setTimeLimit(1000f);
		
		ProblemComparator comparator = new ProblemComparator("CodeFolder/2.exe", m);
		comparator.compare();
		
		ProblemStatus actual = ProblemStatus.RUNTIME_ERROR;
		assertEquals(comparator.getProblemStatus(), actual);
	}
	
	@Test
	public void testTimeLimitError() throws ProblemExceptionHandler {
		MarkingData m = new MarkingData();
		m.setListInput(addInput());
		m.setListOutput(addOutput());
		m.setTimeLimit(1000f);
		
		ProblemComparator comparator = new ProblemComparator("CodeFolder/3.exe", m);
		comparator.compare();
		
		ProblemStatus actual = ProblemStatus.TIME_LIMIT;
		assertEquals(comparator.getProblemStatus(), actual);
	}
	
	@Test
	public void testWrongAnswer() throws ProblemExceptionHandler {
		MarkingData m = new MarkingData();
		m.setListInput(addInputWrong());
		m.setListOutput(addOutput());
		m.setTimeLimit(1000f);
		ProblemComparator comparator = new ProblemComparator("CodeFolder/2.exe", m);
		comparator.compare();
		
		ProblemStatus actual = ProblemStatus.WRONG_ANSWER;
		assertEquals(comparator.getProblemStatus(), actual);
	}
	
	private List<Input> addInput(){
		List<Input> lip = new ArrayList<>();
		
		Input ip = new Input();
		ip.setInputData("7 1 4");
		lip.add(ip);
		
		Input ip1 = new Input();
		ip1.setInputData("30 20 10");
		lip.add(ip1);
		
		Input ip2 = new Input();
		ip2.setInputData("1 4 100");
		lip.add(ip2);
		
		Input ip3 = new Input();
		ip3.setInputData("100 1 91");
		lip.add(ip3);
		
		Input ip4 = new Input();
		ip4.setInputData("1 45 100");
		lip.add(ip4);
		return lip;
	}
	
	private List<Input> addInputWrong(){
		List<Input> lip = new ArrayList<>();
		
		Input ip = new Input();
		ip.setInputData("7 7 5");
		lip.add(ip);
		
		Input ip1 = new Input();
		ip1.setInputData("30 20 10");
		lip.add(ip1);
		
		Input ip2 = new Input();
		ip2.setInputData("1 4 100");
		lip.add(ip2);
		
		Input ip3 = new Input();
		ip3.setInputData("100 1 91");
		lip.add(ip3);
		
		Input ip4 = new Input();
		ip4.setInputData("1 45 100");
		lip.add(ip4);
		return lip;
	}
	
	private List<Input> addInputRuntime(){
		List<Input> lip = new ArrayList<>();
		
		Input ip = new Input();
		ip.setInputData("7");
		lip.add(ip);
		
		Input ip1 = new Input();
		ip1.setInputData("30 20 10");
		lip.add(ip1);
		
		Input ip2 = new Input();
		ip2.setInputData("1 4 100");
		lip.add(ip2);
		
		Input ip3 = new Input();
		ip3.setInputData("100 1 91");
		lip.add(ip3);
		
		Input ip4 = new Input();
		ip4.setInputData("1 45 100");
		lip.add(ip4);
		return lip;
	}
	
	
	private List<Output> addOutput(){
		List<Output> lip = new ArrayList<>();
		
		Output ip = new Output();
		ip.setOutputData("6");
		lip.add(ip);
		
		Output ip1 = new Output();
		ip1.setOutputData("20");
		lip.add(ip1);
		
		Output ip2 = new Output();
		ip2.setOutputData("99");
		lip.add(ip2);
		
		Output ip3 = new Output();
		ip3.setOutputData("99");
		lip.add(ip3);
		
		Output ip4 = new Output();
		ip4.setOutputData("99");
		lip.add(ip4);
		return lip;
	}

}
