package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZerowebApp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("signin_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		String pagetitle=driver.getTitle();
		System.out.println(pagetitle);
		String currurl=driver.getCurrentUrl();
		System.out.println(currurl);
		String headertext=driver.findElement(By.xpath("//h2[contains(text(),'Cash Accounts')]")).getText();
		System.out.println(headertext);
		String fontcss=driver.findElement(By.xpath("//h2[contains(text(),'Cash Accounts')]")).getCssValue("font-size");
		System.out.println(fontcss);
		String tagname=driver.findElement(By.xpath("//h2[contains(text(),'Cash Accounts')]")).getTagName();
		System.out.println(tagname);
		String linkvalue=driver.findElement(By.xpath("(//a[text()='Savings'])[1]")).getAttribute("href");
		System.out.println(linkvalue);

	}

}
