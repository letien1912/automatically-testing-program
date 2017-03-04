package Test;

public class moenmen {
	public static void main(String[] args) {
		CompileProblemAnswer compile = new CompileProblemAnswer("Problem/1");
		compile.start();
		CompareProblemAnswer compare = null;
		if(compile.isCompiledSuccess()) {
			compare = new CompareProblemAnswer("Problem/1");
			compare.compare();
			System.out.println(compare.getNumberCorrectTest() +"/" +compare.getLengthOfTestCase());
		} else {
			System.out.println("COMPILE error");
			System.out.println(compile.getErrorCompile());
		}
	}
}
