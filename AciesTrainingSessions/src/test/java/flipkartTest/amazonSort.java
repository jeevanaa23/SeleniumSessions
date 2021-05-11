package flipkartTest;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonSort {

	WebDriver driver;

	@Test
	public void a_pageload() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile phones");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Samsung']")).click();
		// amazonSort ref=amazonSort.initElements(driver, amazonSort.class);
		AmazonsortRep az = PageFactory.initElements(driver, AmazonsortRep.class);
		az.b_applyFilters();

	}

	@Test
	public void c_verifySort() {
		List<WebElement> sortOrd = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<Integer> priceList = new LinkedList<Integer>();
		for (int i = 0; i < sortOrd.size(); i++) {
			Integer price = null;
			String str = sortOrd.get(i).getText().replace(",", "");
			price = Integer.parseInt(str);
			priceList.add(price);
		}
		Collections.sort(priceList);
		// List<Integer> newsort=Integer.parseInt(sortOrd.sort(null));

		for (int i = 0; i < sortOrd.size(); i++) {
			Integer temp = null;
			String str = sortOrd.get(i).getText().replace(",", "");
			temp = Integer.valueOf(str);
			if (temp.equals(priceList.get(i))) {
				System.out.println(sortOrd.get(i).getText());
				System.out.println(priceList.get(i));
				System.out.println("-----------------items price matched-----------------");
			}

		}

	}
	
	@AfterMethod
	public void testStatus(ITestResult result) {
		if(result.getMethod().getMethodName().equals("c_verifySort")) {
			assertTrue(result.getStatus()==ITestResult.SUCCESS,"Sorted Correctly");
		}
		
	}

}
