package seleniumGridExamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YourLogoScript {

	
	WebDriver driver;
	@Test
	public void a_pageload() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
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
