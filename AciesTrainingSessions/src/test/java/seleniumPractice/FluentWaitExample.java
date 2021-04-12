package seleniumPractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver);
		 wait.withTimeout(Duration.ofSeconds(10))
	       .pollingEvery(Duration.ofSeconds(2))
	       .withMessage("NO Such ID Found")
	       .ignoring(NoSuchElementException.class);
		 driver.findElement(By.id("identifierId")).sendKeys("jeekarthi18@gmail.com");
		 driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);		 
		 
		 
		 
	}

}
