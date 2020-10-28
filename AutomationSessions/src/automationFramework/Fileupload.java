package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fileupload {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement fileup=driver.findElement(By.id("uploadfile_0"));
		fileup.sendKeys("C:\\Users\\Mj\\Desktop\\Testing_Material\\Work_Assessment\\SpiraTeam_defects\\tc_30.JPG");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();

	}

}
