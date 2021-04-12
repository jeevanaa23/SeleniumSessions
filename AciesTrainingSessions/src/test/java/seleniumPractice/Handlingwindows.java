package seleniumPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingwindows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Set <String> naukriwindows=driver.getWindowHandles();
		Iterator<String> it=naukriwindows.iterator();
		while(it.hasNext())
		{
			//System.out.println(it.next().toString());
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			driver.close();
		}
		//driver.close();
		
	}

}
