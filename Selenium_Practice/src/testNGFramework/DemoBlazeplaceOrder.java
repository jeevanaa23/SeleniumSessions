package testNGFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoBlazeplaceOrder {
	
	WebDriver driver;

	@Test
	public void a_placeOrder() throws InterruptedException {

		WebElement phoneSelect = driver.findElement(By.xpath("//a[contains(text(),'Nokia lumia 1520')]"));
		phoneSelect.click();
		Thread.sleep(2000);
		WebElement addButton = driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]"));
		addButton.click();
		Alert abox = driver.switchTo().alert();
		System.out.println(abox.getText());
		abox.accept();
		Thread.sleep(2000);

	}

	@Test
	public void b_checkOut() throws InterruptedException {
		driver.findElement(By.id("cartur")).click();
		Thread.sleep(1000);
		WebElement poButton = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
		poButton.click();
		driver.findElement(By.id("name")).sendKeys("JohnnyGale");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Chennai");
		driver.findElement(By.id("card")).sendKeys("458974562564");
		driver.findElement(By.id("month")).sendKeys("07");
		driver.findElement(By.id("year")).sendKeys("2024");
		WebElement orderButton = driver.findElement(By.xpath("//button[contains(text(),'Purchase')]"));
		orderButton.click();
		Thread.sleep(2000);

	}
	
	@BeforeSuite
	public void beforeSuite() throws InterruptedException {
		System.out.println("Entering Before Suite");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Entering After Suite2");
		driver.close();
	}
}
