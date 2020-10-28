package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingiframes {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://nunzioweb.com/index.shtml");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		int isize=driver.findElements(By.tagName("iframe")).size();
		System.out.println(isize);
		driver.switchTo().frame("oddcouple");
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'A television')]")).getText());

	}

}
