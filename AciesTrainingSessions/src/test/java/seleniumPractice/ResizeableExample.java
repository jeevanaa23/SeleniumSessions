package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizeableExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("//body/div[@id='resizable']/div[3]")).getText());
		WebElement Res = driver.findElement(By.xpath("//body/div[@id='resizable']/div[3]"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(Res, 200, 400).perform();
	}

}
