package amazonTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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

public class AddAddress extends SearchProduct {
	WebDriver driver;
	Properties prop;
	Workbook book;
	Sheet sheet;
	static Logger log = Logger.getLogger(AddAddress.class);
	Object rowValue;

	public AddAddress(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	public void newAddress(WebDriver driver, Properties prop) throws EncryptedDocumentException, IOException {
		log.info("Entering Add Address");
		String Testdatasheet = prop.getProperty("excelPath");
		ArrayList<Object> list=new ArrayList<Object>();
		File file = new File(Testdatasheet);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		//Iterator<RowIterator> row=sheet.rowIterator();
		for (int i = 0; i <= rowCount; i++) {
			int cellcount = sheet.getRow(i).getLastCellNum();
			System.out.println("Row" + i + " data is :");
			for (int j = 0; j < cellcount; j++) {
				if (sheet.getRow(i).getCell(j).getCellType() == CellType.STRING) {
					System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + ",");
					rowValue = sheet.getRow(i).getCell(j).getStringCellValue();
				} else if (sheet.getRow(i).getCell(j).getCellType() == CellType.NUMERIC) {
					rowValue = sheet.getRow(i).getCell(j).getNumericCellValue();
					System.out.print(sheet.getRow(i).getCell(j).getNumericCellValue());
				}
				list.add(rowValue);
			}

			
		}
		Iterator<Object> it=list.iterator();
		while(it.hasNext()) {
			System.out.println("Arraylist Items"+it.next());
		}
		//System.out.println("Arraylist Items"+list);
	}
	
	public void newAddress() throws InterruptedException {
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
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']")).sendKeys("Krithick");
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys("624301");
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']")).sendKeys("3/245");
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']")).sendKeys("Chinnalapatti");
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']/following::span[5]")).click();
		driver.findElement(By.xpath("//a[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_30']")).click();
		
		
		
		
		
	}
	
	
	
	
}
