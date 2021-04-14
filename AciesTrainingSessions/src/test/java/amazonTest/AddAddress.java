package amazonTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddAddress extends SearchProduct {
	public static WebDriver driver;
	public static Properties prop;
	Workbook book;
	Sheet sheet;
	static Logger log = Logger.getLogger(AddAddress.class);
	Object rowValue;
	HashMap<Object,Object> datas=new HashMap<Object, Object>();

	public AddAddress(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	@DataProvider
	public Object[][]  newAddress(WebDriver driver, Properties prop) throws EncryptedDocumentException, IOException, InterruptedException {
		log.info("Entering Add Address");
		dataRetrieveUtils dr=new dataRetrieveUtils(driver, prop);
		return dr.dataret();
		
		}
		/*
		 * Iterator<Object> it=list.iterator(); while(it.hasNext()) {
		 * System.out.println("Arraylist Items"+it.next()); }
		 * //System.out.println("Arraylist Items"+list);
		 */	
	@Test(dataProvider="newAddress")
	public void a_loadData(HashMap<Object,Object> data) throws InterruptedException {
		log.info("TestMethod");
		datas.putAll(data);
		addnewAddress(datas);
		
	}
	
	public void addnewAddress(HashMap<Object, Object> datas) throws InterruptedException {
		log.info("Entering data Provider Add Address");
		log.info(datas);
		WebElement mouseac = driver.findElement(By.xpath("//span[@class='nav-line-2 nav-long-width']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(mouseac).build().perform();
		driver.findElement(By.xpath("//span[contains(text(),'Your Account')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h2[contains(text(),'Your Addresses')]")).click();
		driver.findElement(By.xpath("//div[@id='ya-myab-plus-address-icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		driver.findElement(By.xpath("//a[@id='address-ui-widgets-countryCode-dropdown-nativeId_101']")).click();
		/*
		 * Select country=new Select(driver.findElement(By.
		 * xpath("//span[@class='a-button-text a-declarative']")));
		 * country.selectByVisibleText("India");
		 */
		log.info("Typing FullName"+datas.get("FullName").toString());
		driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys(datas.get("FullName").toString());
		driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys(datas.get("Mobile Number").toString());
		driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys(datas.get("Pin").toString());
		driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys(datas.get("Door.No").toString());
		driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys(datas.get("City").toString());
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']/following::span[5]")).click();
		driver.findElement(By.xpath("//a[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_30']")).click();
		
		
		
		
		
	}
	
	
	
	
}
