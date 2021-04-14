package amazonTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProduct {

	static Logger log = Logger.getLogger(SearchProduct.class);
	public static WebDriver driver;
	String driverPath;
	String mobModel, searchBoxInput,mobMod;
	public static Properties prop;
	WebDriverWait wait;

	@BeforeTest
	public void readPropfile() throws IOException {
		log.info("Entered SearchProduct");
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"D:\\Selenium\\New_Workspace\\SeleniumSessions\\AciesTrainingSessions\\src\\test\\resources\\read.properties");
		prop.load(ip);
		driverPath = prop.getProperty("chromeDriverpath");
		mobModel = prop.getProperty("mobileModel");
		searchBoxInput = prop.getProperty("searchip");
		mobMod=prop.getProperty("mobMod");
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
			if (driver.getPageSource().contains(mobMod)) {
			driver.findElement(By.linkText(mobMod)).click();
			}
			else {
				log.info("Object not found searching the next page");
				driver.findElement(By.xpath("//a[text()='Next']")).click();
				Thread.sleep(2000);
				 driver.findElement(By.linkText(mobModel)).click(); 

			}

				
			}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-line-2 nav-long-width']")));
		//Orderhistory ord = new Orderhistory();
		//ord.read_Orderhistory(driver, prop);
		
		}
	
	@DataProvider(name = "newAddress")
	public Object[][] newAddress()throws EncryptedDocumentException, IOException, InterruptedException {
		log.info("Entering Add Address");
		dataRetrieveUtils dr = new dataRetrieveUtils(driver, prop);
		Object data[][] = dr.dataret();
		return data;

	}
	
	@Test(dataProvider="newAddress")
	public void c_addAddress(HashMap<Object,Object> data) throws EncryptedDocumentException, IOException, InterruptedException {
		AddAddress newad = new AddAddress(driver, prop);
		//newad.newAddress(driver, prop);
		//newad.addnewAddress(data);
		newad.assertExistingAdd();
	
		
	}
			

	}


