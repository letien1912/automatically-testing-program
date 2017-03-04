package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;
import java.nio.Buffer;

public class TestBuildCppFile {
	public static void main(String[] args) throws IOException, InterruptedException {
		Process buildprocess = new ProcessBuilder("g++", "Cfolder/test.cpp", "-o", "Cfolder/test").start();
		 BufferedReader stdError = new BufferedReader(new InputStreamReader(buildprocess.getErrorStream()));
		 String error;
//        System.out.println("It will take time so keep the patience:\n" + stdError.readLine());
        while ((error = stdError.readLine()) != null) {
			System.out.println(error);
		}
        
        /*Read file*/
        String testinput = null;
        String input = "";
        BufferedReader readTest = new BufferedReader(new FileReader("Cfolder/test.txt"));
        while((testinput = readTest.readLine()) != null){
        	input += testinput;
        }
        /*run & add add input*/
		String[] params = { "Cfolder\\test.exe" };
		Process process = new ProcessBuilder(params).start();
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
		bW.write(input);
		bW.close();
		
		/* get output */
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		
		process = new ProcessBuilder(params).start();
		br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		bW = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
		bW.write(input);
		bW.close();
		int waitFlag = process.waitFor();// Wait to finish application
		// execution.
		if (waitFlag == 0) {
			int returnVal = process.exitValue();
		}
		
		

		// try {
		// launcher.start();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\minecraft_server\\test.exe",
		// null, new File("c:\\program files\\test\\"));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// try {
		// Process p = Runtime.getRuntime().exec("cmd /C gcc " + "test.cpp" + "
		// -o " + "test", null, new File("Cfolder/test.cpp"));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// String command = "cmd /c g++ Cfolder/test.cpp -o Cfolder/test";
		// Process child = Runtime.getRuntime().exec(command);
		//
		// Thread.sleep(5000);
		// String command2 = "cmd /c start Cfolder/test.exe";
		// Process child2 = Runtime.getRuntime().exec(command2);
		// InputStream is = child2.getInputStream();
		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// int r = child2.waitFor();
		// String line = null;
		// System.out.println(".");
		// while ((line = br.readLine()) != null) {
		// System.out.println(line + ".\n" );
		// }
		// if(r == 0){
		// System.out.println("no error");
		// }
		// BufferedReader stdInput = new BufferedReader(new
		// InputStreamReader(child2.getInputStream()));
		// BufferedWriter stdOUt = new BufferedWriter(new
		// OutputStreamWriter(child2.getOutputStream()));
		//
		// ProcessBuilder pb = new ProcessBuilder(command2);
		// pb.redirectOutput(Redirect.INHERIT);
		// pb.redirectError(Redirect.INHERIT);
		// Process p = pb.start();
		// System.out.println(".");
		// String sb;
		// while ((sb = stdInput.readLine()) != null) {
		// System.out.println(sb);
		// }
		// Process p = Runtime.getRuntime().exec("Cfolder/test.exe");
		// InputStream in = p.getInputStream();
		// for (int i = 0; i < in.available(); i++) {
		// System.out.println("" + in.read());
		// }
		// System.out.println("Endl");
		// p.destroy();
		// ProcessBuilder pro = new ProcessBuilder(command);
		// pro.start();

	}
}
