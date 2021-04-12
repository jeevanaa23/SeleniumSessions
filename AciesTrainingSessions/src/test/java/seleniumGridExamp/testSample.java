package seleniumGridExamp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class testSample {
	
	
	@Test
	public void testLogin() throws MalformedURLException {
		
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
		RemoteWebDriver rmd=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		rmd.get("http://gmail.com");
		rmd.findElement(By.id("identifierId")).sendKeys("jeekarthi18@gmail.com");
		//rmd.findElement(By.xpath("//span[text()='Next']")).click();
		rmd.quit();
		
	}

}
