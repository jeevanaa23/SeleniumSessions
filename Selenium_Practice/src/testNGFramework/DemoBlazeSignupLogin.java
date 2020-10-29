package testNGFramework;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoBlazeSignupLogin {

	WebDriver driver;

	@Test
	public void a_signUp() throws InterruptedException {
	WebElement signupButton=driver.findElement(By.id("signin2"));
	signupButton.click();
	Thread.sleep(1000);
	driver.findElement(By.id("sign-username")).sendKeys("Hgigi");
	driver.findElement(By.id("sign-password")).sendKeys("october");
	WebElement signup=driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
	signup.click();
	Thread.sleep(3000);
	Alert popup=driver.switchTo().alert();
	System.out.println(popup.getText());
	popup.accept();
	Thread.sleep(1000);
	}
	
	@Test
	public void b_login() throws InterruptedException {
		WebElement signupButton=driver.findElement(By.id("login2"));
		signupButton.click();
		Thread.sleep(1000);
		driver.findElement(By.id("loginusername")).sendKeys("Hgigi");
		driver.findElement(By.id("loginpassword")).sendKeys("october");
		WebElement login=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		login.click();
		Thread.sleep(1000);

		
	}
	
	@BeforeSuite
	public void beforeSuite() throws InterruptedException {
		System.out.println("Entering Before Suite");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@AfterSuite
	public void afterSuite() throws InterruptedException {
		System.out.println("Entering AfterSuite");
		Thread.sleep(3000);
		WebElement logout=driver.findElement(By.id("logout2"));
		logout.click();
	}

}
