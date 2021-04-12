package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("march31@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(5000);
		WebElement radio = driver.findElement(By.id("id_gender1"));
		radio.click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Joseph");
		driver.findElement(By.id("customer_lastname")).sendKeys("Tribbiani");
		driver.findElement(By.id("passwd")).sendKeys("Sep@292020");
		Select date = new Select(driver.findElement(By.id("days")));
		date.selectByVisibleText("25  ");
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByVisibleText("January ");
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByVisibleText("1997  ");
		WebElement checkbox = driver.findElement(By.id("newsletter"));
		checkbox.click();
		WebElement checkbox2 = driver.findElement(By.id("optin"));
		checkbox2.click();
		driver.findElement(By.id("firstname")).sendKeys("Joseph");
		driver.findElement(By.id("lastname")).sendKeys("Tribbiani");
		driver.findElement(By.id("address1")).sendKeys("74,MeadowBrook Road");
		driver.findElement(By.id("city")).sendKeys("Edison");
		
		WebElement states=driver.findElement(By.id("id_state"));
		Select stateUs = new Select(driver.findElement(By.id("id_state")));
		List<WebElement> usStates=states.findElements(By.tagName("option"));
		stateUs.selectByVisibleText("New Jersey");
		
		driver.findElement(By.id("postcode")).sendKeys("08837");
		driver.findElement(By.id("phone_mobile")).sendKeys("732-646-0236");
		/*
		 * WebElement submitButton=driver.findElement(By.id("submitAccount"));
		 * submitButton.click(); driver.findElement(By.linkText("Sign out")).click();
		 */
	}
}
