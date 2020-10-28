package automationFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouserightclickdoubleclick {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement right=driver.findElement(By.xpath("//span[contains(text(),'right')]"));
		Actions rclick=new Actions(driver);
		rclick.contextClick(right).build().perform();
		driver.findElement(By.xpath("//span[contains(text(),'Copy')]")).click();
		Alert popup=driver.switchTo().alert();
		System.out.println(popup.getText());
		popup.accept();
	}

}
