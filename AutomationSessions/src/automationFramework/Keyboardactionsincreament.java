package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Keyboardactionsincreament {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/inputs");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[contains(text(),'Number')]/following::input")).sendKeys("5");
		Thread.sleep(2000);
		Actions inc=new Actions(driver);
		for(int i=0;i<5;i++) {
		inc.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);
		}
		
		for(int i=0;i<5;i++)
		{
			inc.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);}
	}

}
