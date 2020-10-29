package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Jpetstorepractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("sivakardoss1702");
		driver.findElement(By.name("password")).sendKeys("petstoredemo");
		driver.findElement(By.name("repeatedPassword")).sendKeys("petstoredemo");
		driver.findElement(By.name("account.firstName")).sendKeys("Shiva");
		driver.findElement(By.name("account.lastName")).sendKeys("Karthikeyan");
		driver.findElement(By.name("account.email")).sendKeys("sivadoss@gmail.com");
		driver.findElement(By.name("account.phone")).sendKeys("8965231445");
		driver.findElement(By.name("account.address1")).sendKeys("Guindy");
		driver.findElement(By.name("account.city")).sendKeys("Chennai");
		driver.findElement(By.name("account.state")).sendKeys("TamilNadu");
		driver.findElement(By.name("account.zip")).sendKeys("600028");
		driver.findElement(By.name("account.country")).sendKeys("India");
		Select langpref=new Select(driver.findElement(By.name("account.languagePreference")));
		langpref.selectByVisibleText("english");
		Select favCat=new Select(driver.findElement(By.name("account.favouriteCategoryId")));
		favCat.selectByVisibleText("FISH");
		WebElement listcheck=driver.findElement(By.name("account.listOption"));
		listcheck.click();
		WebElement regbutton=driver.findElement(By.name("newAccount"));
		regbutton.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.name("username")).getAttribute("value"));
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("petstoredemo");
		WebElement login=driver.findElement(By.name("signon"));
		login.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Successfully Completed");

	}

}
