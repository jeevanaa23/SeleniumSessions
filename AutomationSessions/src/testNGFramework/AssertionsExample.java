package testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsExample {

	WebDriver driver;

	@Test
	public void a_pageload() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test
	public void assertEquals() {
		String textData = driver.findElement(By.xpath("//strong[contains(text(),'Online Banking')]")).getText();
		Assert.assertEquals(textData, "ONLINE BANKINGG");
		System.out.println("AssertEquals Pass");
	}

	@Test
	public void assertnotEquals() {
		String textData = driver.findElement(By.xpath("//strong[contains(text(),'Online Banking')]")).getText();
		Assert.assertNotEquals(textData, "Online Banking");
		System.out.println("AssertNotEquals Pass");
	}

	@Test
	public void assertTrue() {
		Assert.assertTrue("ONLINE BANKING"
				.equals(driver.findElement(By.xpath("//strong[contains(text(),'Online Banking')]")).getText()));
		System.out.println("AssertTrue Passed");
	}
	
	@Test
	public void assertFalse() {
		String textData = driver.findElement(By.xpath("//strong[contains(text(),'Online Banking')]")).getText();
		Assert.assertFalse("Online Banking".equals(textData));
		System.out.println("Assert False PAssed");
	}
	
	@Test
	public void assertNotnull() {
		Object obj=driver.getTitle();
		Assert.assertNotNull(obj);
		System.out.println("Assert Not Null PAss");
	}
	
	@Test
	public void assertNull() {
		Object obj=null;
		Assert.assertNull(obj);
		System.out.println("Assert Nul PAssed");
	}
	
	
}
