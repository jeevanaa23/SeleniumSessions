package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Rediffmailpractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[(text()='Full Name')]/following::input[1]")).sendKeys("Kristina");
		driver.findElement(By.xpath("//td[contains(text(),'Choose a Rediffmail ID')]/following::input[1]"))
				.sendKeys("coldwellk");
		driver.findElement(By.xpath("//td[contains(text(),'Password')]/following::input[1]")).sendKeys("Kristy@2020");
		driver.findElement(By.xpath("//td[contains(text(),'Retype password')]/following::input[1]"))
				.sendKeys("Kristy@2020");
		/*WebElement checkbox = driver.findElement(
				By.xpath("//td[contains(text(),'Retype')]/following::input[3]"));
		checkbox.click();
		Select secQues=new Select(driver.findElement(By.xpath("//td[contains(text(),'Select a Security Question')]/following::select[1]")));
		secQues.selectByVisibleText("What is your favourite food?");
		driver.findElement(By.xpath("//td[contains(text(),'Enter an Answer')]/following::input[1]")).sendKeys("Briyani");
		driver.findElement(By.xpath("//td[contains(text(),\"Maiden Name\")]/following::input[1]")).sendKeys("Teigen");
		*/
		driver.findElement(By.xpath("//td[contains(text(),'Alternate Email')]/following::input[1]")).sendKeys("chrisk12@gmail.com");
		driver.findElement(By.id("mobno")).sendKeys("7325468960");
		Select date=new Select(driver.findElement(By.xpath("//td[contains(text(),'Date of Birth')]/following::select[1]")));
		date.selectByValue("09");
		Select month=new Select(driver.findElement(By.xpath("//td[contains(text(),'Date of Birth')]/following::select[2]")));
		month.selectByVisibleText("JUN");
		Select year=new Select(driver.findElement(By.xpath("//td[contains(text(),'Date of Birth')]/following::select[3]")));
		year.selectByVisibleText("1994");
		driver.findElement(By.xpath("//td[contains(text(),'Gender')]/following::input[2]")).click();
		Select country= new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("India");
		Select city=new Select(driver.findElement(By.xpath("//td[contains(text(),'City')]/following::Select[1]")));
		city.selectByVisibleText("Chennai");
		Thread.sleep(20000);
		System.out.println("Click Register");
		WebElement regButton= driver.findElement(By.id("Register"));
		regButton.click();
		
	}

}
