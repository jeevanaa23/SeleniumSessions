package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Similarelements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/Donald_Trump");
		driver.manage().window().maximize();
		int linkcount=driver.findElements(By.tagName("a")).size();
		System.out.println(linkcount);
		System.out.println("No.of Images"+driver.findElements(By.tagName("img")).size());
	}

}
