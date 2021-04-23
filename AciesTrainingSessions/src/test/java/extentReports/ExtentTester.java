package extentReports;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTester {

	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest extes;
	
	@BeforeTest
	public void setUp() {
		htmlReporter=new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Extent-Report_Sample");
		htmlReporter.config().setReportName("Extent_001");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//Giving some system, Environment, Organization or Author information
		
		extent.setSystemInfo("QA", "Ross");
		extent.setSystemInfo("ENV", "QA");
		extent.setSystemInfo("Release/No", "Reg_001");
	}
	
	@AfterTest
	public void endRep() {
		extent.flush();
	}
	
	@Test
	public void doLogIn() {
		extes=extent.createTest("Login Test");
		System.out.println("Executing login test");
	}
	
	@Test
	public void doUserReg() {
		extes=extent.createTest("User Registration");
		Assert.fail("User reg test failed");
	}
	
	@Test
	public void isSkip() {
		extes=extent.createTest("Skip Test");
		throw new SkipException("Skipping the test case");
	}
	
	@AfterMethod
	public void teatDown(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			String logText = "<b>" + "Test case : - " + methodName.toUpperCase() + " Passed " + "</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			extes.pass(m);
			
		}else if(result.getStatus()==ITestResult.FAILURE) {
			String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			extes.log(extes.getStatus(), "<details>"+"<summary>"+"<b>"+"<font color="+"red>"+"Exception Occured : Click to see"+"</font>"+"</b>"+"</summary>"+excepionMessage.replaceAll(",","<br>")+"</details>"+"\n");
			String failureLogg ="Test Failed";
			Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
			extes.log(Status.FAIL, m);
		
		}else if(result.getStatus()==ITestResult.SKIP) {
			String methodName = result.getMethod().getMethodName();
			String logText = "<b>" + "Test case : - " + methodName.toUpperCase() + " Skipped " + "</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			extes.pass(m);
			
		}
		
	}
	
	
}
