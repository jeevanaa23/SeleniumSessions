package flipkartTest;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import java.util.function.*;

public class TestSearch extends TestBase {

	@Test(priority = 1)
	public void searchTest() throws InterruptedException {
		// close the login window
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/button")).click();

		// Search the product "Men's wrist watch"
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mens wrist watches analog");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();

		// Select the value 3000 at maximum price list
		Select price = new Select(driver.findElement(By.xpath("//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")));
		price.selectByValue("3000");
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void clkChkButtons() throws InterruptedException {

		String assuredchckbox = "//select//following::section//img";
		WebElement ele = getElement(By.xpath(assuredchckbox));
		elementClick(ele);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		/*
		 * String morelink="//div[text()='Brand']/following::span[1]"; WebElement
		 * more=getElement(By.xpath(morelink));
		 * driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 * elementClick(more);
		 */
		WebElement fstrck=getElement(By.xpath("//div[text()='Brand']/following::div[6]"));
		elementClick(fstrck);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement menc=driver.findElement(By.xpath("//div[text()='Ideal For']/following::div[13]"));
		elementClick(menc);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement boysc=getElement(By.xpath("//div[text()='Boys']"));
		elementClick(boysc);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		

	}
	
	private void elementClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
		
	}

	public static WebElement getElement(final By locator) throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver arg0) {
				return arg0.findElement(locator);
			}

		});
		Thread.sleep(3000);
		return element;
	}
	
	@Test(priority=3,dependsOnMethods="clkChkButtons")
	public void addtoCart() throws InterruptedException {
		driver.get(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> searchList=driver.findElements(By.xpath("//a[@class='IRpwTa']"));
		int itemIndex=searchList.size();
		System.out.println("n-1th item"+searchList.get(itemIndex-2).getText());
		elementClick(searchList.get(itemIndex-2));
		ArrayList<String> wintabs= new ArrayList <String>(driver.getWindowHandles());
		driver.switchTo().window(wintabs.get(1));
		System.out.println(driver.findElement(By.xpath("//h1/span[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText());
		WebElement cartButton=driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		//elementClick(cartButton);
		if(cartButton.isDisplayed()) {
		cartButton.click();
	}
		else {
			
		}
	
}}
