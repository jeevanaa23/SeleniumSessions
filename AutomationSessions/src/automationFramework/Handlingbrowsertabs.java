package automationFramework;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingbrowsertabs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement create=driver.findElement(By.xpath("(//a[contains(text(),'Create an account')])[1]"));
		create.click();
		ArrayList <String> wintabs=new ArrayList <String>(driver.getWindowHandles());
		driver.switchTo().window(wintabs.get(1));
		driver.findElement(By.id("firstName")).sendKeys("sara");
		
	}

}
