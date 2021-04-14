package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(listernerPackages.TestNGListeners.class)
public class AssertionsExample {

	
	
	public static WebDriver driver;
	String textData;

	//@Parameters({"browser"})
	@Test(/*groups="Run"*/)
	public void a_pageload(/*String browser*/) {
		//System.out.println(browser);
		//if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		/*
		 * }else if(browser.equals("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver(); }
		 */
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//*[@id='site-name']/a")).getText());
	}

	@Test(/*groups="Run",*/dependsOnMethods="a_pageload")
	public void b_softassertEquals() {
		SoftAssert soa=new SoftAssert();
		textData = driver.findElement(By.id("site-name")).getText();
		soa.assertEquals(textData, "Selenium Easy", "AssertEquals Pass");
		soa.assertNotEquals("Selenium Easy", textData, "Both are equal");
		soa.assertTrue(driver.findElement(By.id("site-name")).getText().equals("Selenium Easy"),"Assertion True");
		soa.assertAll();
	}
	
	@Test(dependsOnMethods={"b_softassertEquals","a_pageload"})
	public void c_asssertNotequal() {
		Assert.assertNotEquals("Selenium Easy", textData, "Both are equal");
	}
	

	

	
}
