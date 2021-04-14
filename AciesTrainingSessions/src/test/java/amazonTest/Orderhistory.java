package amazonTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Orderhistory {
	static Logger log=Logger.getLogger(Orderhistory.class);
	WebDriver driver;
	ArrayList<String> orderList = new ArrayList<String>();
	WebDriverWait wait;

	public Orderhistory() {
		this.driver = driver;
	}

	Properties prop;

	@Test
	public void read_Orderhistory(WebDriver driver, Properties prop) throws InterruptedException, IOException {
		this.prop = prop;
		log.info("Reading OrderHistory");
		ArrayList<String> wintabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wintabs.get(1));
		WebElement mouseac = driver.findElement(By.xpath("//span[@class='nav-line-2 nav-long-width']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(mouseac).build().perform();
		driver.findElement(By.xpath("(//span[text()='Sign in'])[1]")).click();
		wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
		//Thread.sleep(2000);

		if (driver.getTitle().matches("Amazon Sign In")) {
			driver.findElement(By.id("ap_email")).sendKeys(prop.getProperty("email"));
			driver.findElement(By.id("continue")).click();
			//Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
			driver.findElement(By.id("ap_password")).sendKeys(prop.getProperty("pwd"));
			driver.findElement(By.id("signInSubmit")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-line-2 nav-long-width']")));
			mouseac = driver.findElement(By.xpath("//span[@class='nav-line-2 nav-long-width']"));
			mouse.moveToElement(mouseac).build().perform();
			driver.findElement(By.xpath("//span[contains(text(),'Your Orders')]")).click();
			if (driver.getTitle().matches("Your Orders")) {
				List<WebElement> delList = driver
						.findElements(By.xpath("//span[contains(text(),'Delivered')]/following::a[@class='a-link-normal'][2]"));
				for (WebElement e : delList) {
					String str = e.getText();
					log.info("The items are  " + str);
					orderList.add(str);
				}
				//writinExcel();
			}

		}

	}

	
	public void writinExcel() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet0 = workbook.createSheet("orderList");

		for (int i = 0; i < orderList.size(); i++) {
			Row row = sheet0.createRow(i);
		//for (int j = 0; j < orderList.size(); j++) {
				Cell cell = row.createCell(0);
				cell.setCellValue(orderList.get(i));
			//}
		}
		File opFile = new File("D:\\Selenium\\New_Workspace\\SeleniumSessions\\AciesTrainingSessions\\Excel\\orderList.xlsx");
		FileOutputStream fo = new FileOutputStream(opFile);
		workbook.write(fo);
		fo.close();
		//System.out.println(orderList);
		log.info("OrderList");
		log.info(orderList);

	}

}
