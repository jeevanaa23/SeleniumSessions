package automationFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingpromptpopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.manage().window().maximize();
		WebElement promptbox=driver.findElement(By.xpath("(//button[text()='Click for Prompt Box'])"));
		promptbox.click();
		Thread.sleep(3000);
		Alert pbox=driver.switchTo().alert();
		System.out.println(pbox.getText());
		pbox.sendKeys("Max");
		pbox.accept();
		//pbox.dismiss();

	}

}
