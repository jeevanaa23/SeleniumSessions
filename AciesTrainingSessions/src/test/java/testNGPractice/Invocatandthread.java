package testNGPractice;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Invocatandthread {

	@Test(invocationCount=5)
	public void invocationCount() {
		System.out.println("Exectuting invocation COut");
	}
	
}
