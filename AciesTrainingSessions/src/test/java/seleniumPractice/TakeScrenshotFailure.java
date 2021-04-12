package seleniumPractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScrenshotFailure extends AssertionsExample {

	public static String filePath;
	public static void takeScreenshot() throws IOException {
		System.out.println("Entering Take Screenshot");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		filePath=System.getProperty("user.dir")+"\\Screeshots\\Failurescreenshot\\FailedScreenshot_"+System.currentTimeMillis()+".jpeg";
		System.out.println(filePath);
		FileUtils.copyFile(scrFile, new File(filePath));

	}

}
