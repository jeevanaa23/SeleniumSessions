package listernerPackages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	  static ExtentReports extent;
    
	public static ExtentReports createInstance(String reportFileLocation)
	{
		System.out.println("------Entering Create Instace--------");
	
		String fileName=reportFileLocation;
	    System.out.println(reportFileLocation);
		//String filepath = getReportPath(reportFilepath);
	    ExtentHtmlReporter	htmlReporter =new ExtentHtmlReporter(reportFileLocation);
	    extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setReportName(fileName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		//To attach the reports
		
		
		//Giving some system, Environment, Organization or Author information
		
		extent.setSystemInfo("Automation Tester", "Rahul");
		extent.setSystemInfo("Organisation", "Acies");
		extent.setSystemInfo("Build number", "Acies-123");


		return extent;
	}

 

}