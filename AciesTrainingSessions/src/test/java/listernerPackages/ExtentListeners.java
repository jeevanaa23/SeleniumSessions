package listernerPackages;

import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ExtentListeners implements ITestListener{

	static Date d = new Date();
	static String fileName = "Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html";  
    static String reportFileLocation =  System.getProperty("user.dir")+"\\Reports\\"+fileName;
private static ExtentReports extent = ExtentManager.createInstance(reportFileLocation);
ExtentTest extes;
//public static ThreadLocal<ExtentTest> testReport =new ThreadLocal<ExtentTest>();

public void onTestStart(ITestResult result)
{
System.out.println(result.getMethod().getMethodName());
extes= extent.createTest(result.getTestClass().getName()+" @TestCase : "+result.getMethod().getMethodName());
}


public void onTestSuccess(ITestResult result) {
	extes=extent.createTest(result.getTestClass().getName()+" @TestCase : "+result.getMethod().getMethodName());
	String methodName = result.getMethod().getMethodName();
	String logText = "<b>" + "Test case : - " + methodName.toUpperCase() + " Passed " + "</b>";
	Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
	extes.pass(m);
	
}

public void onTestFailure(ITestResult result) {

	String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
	extes.log(extes.getStatus(), "<details>"+"<summary>"+"<b>"+"<font color="+"red>"+"Exception Occured : Click to see"+"</font>"+"</b>"+"</summary>"+excepionMessage.replaceAll(",","<br>")+"</details>"+"\n");
	String failureLogg ="Test Failed";
	Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
	extes.log(Status.FAIL, m);
}


public void onFinish(ITestResult result) {
if(extent!=null)
{
extent.flush();
}
}


public void onTestSkipped(ITestResult result) {

	String methodName = result.getMethod().getMethodName();
	String logText = "<b>" + "Test case : - " + methodName.toUpperCase() + " Skipped " + "</b>";
	Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
	extes.pass(m);
	
	
}


public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}


public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}


public void onFinish(ITestContext context) {
	extent.flush();
}



}