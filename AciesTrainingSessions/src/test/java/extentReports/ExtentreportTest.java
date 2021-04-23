package extentReports;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listernerPackages.ExtentListeners.class)
public class ExtentreportTest {
	

		@Test
		public void doLogIn() {
			
			System.out.println("Executing login test");
		}
		
		@Test
		public void doUserReg() {
			Assert.fail("User reg test failed");
		}
		
		@Test
		public void isSkip() {
			
			throw new SkipException("Skipping the test case");
		}
		
	}


