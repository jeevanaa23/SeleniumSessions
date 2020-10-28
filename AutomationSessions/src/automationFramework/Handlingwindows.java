package automationFramework;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingwindows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		ArrayList <String> naukriwindows=new ArrayList <String>(driver.getWindowHandles());
//		for(String winlist:naukriwindows) {
//			System.out.println(winlist);
//		}
		driver.switchTo().window(naukriwindows.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(naukriwindows.get(2));
		System.out.println(driver.getTitle());
		driver.close();
	}

}
