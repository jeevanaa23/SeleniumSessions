package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjects.YourLogoPagerepository;

public class YourLogoScript {

	
	WebDriver driver;
	@Test
	public void a_pageload() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void b_signInsignOut() {
		YourLogoPagerepository ref=PageFactory.initElements(driver, YourLogoPagerepository.class);
		ref.signInflow();
		ref.signOutflow();
	}
	
}
