package testNGFramework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakingScreenshots {
	WebDriver driver;

	@Test
	public void a_login() throws InterruptedException, IOException {
		driver.findElement(By.id("signin_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		getScreenshot();
	}
	
	public void getScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:\\Selenium\\Screeshots\\Screenshot" +System.currentTimeMillis()+ ".png"));
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
	}
}
