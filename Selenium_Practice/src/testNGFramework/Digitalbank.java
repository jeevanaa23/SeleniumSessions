package testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Digitalbank {
	
WebDriver driver;
	
	@Test
	public void a_pageload() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://dbankdemo.com/signup");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@Test
	public void b_digibankform() {
		
		Select title=new Select(driver.findElement(By.id("title")));
		title.selectByVisibleText("Mrs.");
		driver.findElement(By.id("firstName")).sendKeys("Heather");
		driver.findElement(By.id("lastName")).sendKeys("Mary");
		WebElement radio=driver.findElement(By.xpath("(//input[@id='gender'])[2]"));
		radio.click();
		driver.findElement(By.id("dob")).sendKeys("15/10/1995");
		driver.findElement(By.id("ssn")).sendKeys("542-56-7891");
		driver.findElement(By.id("emailAddress")).sendKeys("sivakdoss@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Oct15@2020");
		driver.findElement(By.id("confirmPassword")).sendKeys("Oct15@2020");
		WebElement nexbutton=driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		nexbutton.click();	
		
	}

}
