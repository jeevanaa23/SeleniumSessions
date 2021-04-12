package seleniumPractice;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserExample {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Essentials\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "D:\\Selenium\\Essentials\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
		InternetExplorerDriver driver=new InternetExplorerDriver();
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement create=driver.findElement(By.xpath("(//a[contains(text(),'Create an account')])[1]"));
		create.click();
		ArrayList <String> wintabs=new ArrayList <String>(driver.getWindowHandles());
		//System.out.println(wintabs.toString());
		driver.switchTo().window(wintabs.get(1));
		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys("sara");
		
	

	}

}
