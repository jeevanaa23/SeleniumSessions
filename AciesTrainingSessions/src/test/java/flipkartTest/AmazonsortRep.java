package flipkartTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class AmazonsortRep {
	@FindBy(id = "nav-logo-sprites")
	private WebElement logo;

	@FindBy(id = "nav-main")
	private WebElement menu;

	@FindBy(xpath = "//div[@id='nav-main']")
	WebElement navmain;

	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement signIn;

	@FindBy(xpath = "//span[text()='Avg. Customer Review']/following::span[3]")
	WebElement custRev;

	@FindBy(xpath = "//span[text()='10% Off or more']")
	WebElement discount;

	@FindBy(xpath = "//span[text()='Include Out of Stock']")
	WebElement stock;

	@FindBy(xpath = "//span[text()='Eligible for Pay On Delivery']")
	WebElement cod;

	@FindBy(xpath = "//span[text()='New']")
	WebElement contd;

	@FindBy(xpath = "//span[text()='₹10,000 - ₹20,000']")
	WebElement pricRange;

	@FindBy(xpath = "//span[contains(text(),'Featured')]")
	WebElement sortby;

	@FindBy(xpath = "//ul[@class='a-nostyle a-list-link']//li[2]")
	WebElement sortprice;

	WebDriver driver;
	
	public  AmazonsortRep() {
		this.driver=driver;
	}

	@Test
	public void b_applyFilters() {
		// brand.click();

		custRev.click();
		
		discount.click();
		
		if (stock.isDisplayed()) {
			stock.click();
		}
		
		if (cod.isDisplayed()) {
			cod.click();
		}
		
		if (contd.isDisplayed()) {
			contd.click();
		}
		
		if (pricRange.isDisplayed()) {
			pricRange.click();
		}
		
		sortby.click();
		
		sortprice.click();
		
	}

}
