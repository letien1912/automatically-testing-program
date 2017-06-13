package CodeHandling;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;

import Entities.Input;

class WriteInputTask implements Callable<Boolean> {
	private Process process; 
	private Input ip;
	public WriteInputTask(Process process, Input input) {
		this.process = process;
		this.ip = input;
	}
	@Override
	public Boolean call() throws Exception {
		return WriteInputTest(process);
	}
	
	private boolean WriteInputTest(Process process) {
		BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
		try {
			String input = ip.getInputData();
			bW.write(input);
			bW.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				bW.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
}
