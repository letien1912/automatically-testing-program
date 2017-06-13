package CodeHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

class ActualOutputTask implements Callable<String> {
	private Process process;

	public ActualOutputTask(Process process) {
		this.process = process;
	}

	@Override
	public String call() throws Exception {
		return getActualResult(process);
	}
	
	private String getActualResult(Process process) {
		String answer = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				answer += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return answer;
	}
}