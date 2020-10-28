package automationFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingconfirmationclass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.manage().window().maximize();
		WebElement confirmbox=driver.findElement(By.xpath("(//button[text()='Click me!'])[2]"));
		confirmbox.click();
		Thread.sleep(2000);
		Alert cbox=driver.switchTo().alert();
		System.out.println(cbox.getText());
		cbox.accept();
		//cbox.dismiss();
		//dismiss is for cancel operation
		

	}

}
