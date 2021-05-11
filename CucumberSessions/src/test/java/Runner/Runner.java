package Runner;

import java.io.File;

import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = { "Script" }, monochrome = true, plugin = { "pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html" })

public class Runner {

	public static void setup() {
		Reporter.loadXMLConfig(new File("src/extent-config.xml"));
		// Reporter.setSystemInfo("Test User", System.getProperty("user.name"));

	}
}
