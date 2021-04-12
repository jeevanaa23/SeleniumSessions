package amazonTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProduct {

	static Logger log = Logger.getLogger(SearchProduct.class);
	WebDriver driver;
	String driverPath;
	String mobModel, searchBoxInput;
	Properties prop;
	WebDriverWait wait;

	@BeforeTest
	public void readPropfile() throws IOException {
		log.info("Entered SearchProduct");
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"D:\\Selenium\\Workspace\\AciesTrainingSessions\\src\\test\\resources\\read.properties");
		prop.load(ip);
		driverPath = prop.getProperty("chromeDriverpath");
		mobModel = prop.getProperty("mobileModel");
		searchBoxInput = prop.getProperty("searchip");
		// System.out.println(driverPath);
		this.prop = prop;

	}

	@Test
	public void a_pageload() throws InterruptedException {
		log.info("Entering a_PageLoad");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-logo-sprites")));
	}

	@Test
	public void b_searchproduct() throws InterruptedException, IOException {
		log.info("b_searchProduct Entered");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchBoxInput);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		String xpath = "//span[text()='" + mobModel + "']";
		if (driver.getPageSource().contains(mobModel)) {
			log.info("Item Found");
			driver.findElement(By.xpath(xpath)).click();
		}

		else {
			log.info("Object not found searching the next page");
			driver.findElement(By.xpath("//a[text()='Next']")).click();
			Thread.sleep(2000);
			 driver.findElement(By.linkText(mobModel)).click(); 

		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-line-2 nav-long-width']")));
		
		Orderhistory ord = new Orderhistory(); ord.read_Orderhistory(driver, prop);
		AddAddress newad=new AddAddress(driver, prop);
		newad.newAddress(driver, prop);
		newad.newAddress();
		

	}

}
