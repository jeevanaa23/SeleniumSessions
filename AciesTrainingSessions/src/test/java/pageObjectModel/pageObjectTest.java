package pageObjectModel;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pageObjectTest {

	
	WebDriver driver;
	@Test
	public void a_pageload() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void b_signInsignOut() {
		Pagerepository ref=PageFactory.initElements(driver, Pagerepository.class);
		ref.signin();
		ref.signout();
		driver.close();
	}
	
	
	

}
