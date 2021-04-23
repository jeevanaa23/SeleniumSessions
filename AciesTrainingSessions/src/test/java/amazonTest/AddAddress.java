package amazonTest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAddress extends SearchProduct {
	public static WebDriver driver;
	public static Properties prop;
	Workbook book;
	Sheet sheet;
	static Logger log = Logger.getLogger(AddAddress.class);
	Object rowValue;
	Hashtable<Object, Object> datas = null;

	public AddAddress(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	public void addnewAddress(Hashtable<Object, Object> datas) throws InterruptedException {
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
		log.info("Typing FullName" + datas.get("FullName").toString());
		driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys(datas.get("FullName").toString());
		driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"))
				.sendKeys(datas.get("Mobile Number").toString());
		driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys(datas.get("Pin").toString());
		driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys(datas.get("Door.No").toString());
		driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys(datas.get("City").toString());
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']/following::span[5]")).click();
		driver.findElement(By.xpath("//a[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_30']"))
				.click();

	}
	

	@Test
	public void assertExistingAdd(Hashtable<Object, Object> data) {

		log.info("Entering assertExistingAdd");
		log.info(datas);
		
		WebElement mouseac = driver.findElement(By.xpath("//span[@class='nav-line-2 nav-long-width']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(mouseac).build().perform();
		driver.findElement(By.xpath("//span[contains(text(),'Your Account')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//h2[contains(text(),'Your Addresses')]")).click();
	    boolean expected=driver.getPageSource().contains(data.get("Door.No").toString());
	    Assert.assertEquals(false, expected,"Address already Exists");
	    Assert.assertFalse(expected);
		//	Assert.assertNotEquals(, data.get("Door.No").toString(),"Address Already Exists");

		

	}

}
