package listernerPackages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import amazonTest.TakeScrenshotFailure;



public class AmazontestNGListeners implements ITestListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommon.reportng.escape-output", "false");
		//Reporter.log("<a href=\".\\Screeshots\\error.jpeg\">ScreenShotLink</a>");
		System.out.println("Method failed"+result.getName());
		try {
			TakeScrenshotFailure.takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
	//	System.out.println("Mail Sent");
		
	}

}
