package testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Verificationcommands {
	
	WebDriver driver;
	@Test
	public void a_pageload() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.spicejet.com/");
	driver.manage().window().maximize();
	Thread.sleep(10000);
	}
	
	@Test
	public void b_radioButtonisenabled() throws InterruptedException
	{
		WebElement radio=driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		radio.click();
		System.out.println(radio.isEnabled());
	}
	
	@Test
	public void c_checkBoxisselected() {
		WebElement cbox=driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"));
		cbox.click();
		System.out.println(cbox.isSelected());
	}
	@Test
	public void d_textisDisplayed()
	{
		System.out.println(driver.findElement(By.id("ctl00_HyperLinkLogin")).isDisplayed());
	}
	

}
