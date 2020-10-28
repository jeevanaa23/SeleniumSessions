package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cssselectorclass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.cssSelector("#signin_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		

	}

}
