package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySliders {

	@Test(groups="Run")
	public void a_jquerySliders() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/slider//");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("//body/div[@id='slider']")).getText());
		WebElement slider=driver.findElement(By.xpath("//div[@id='slider']/span"));
		new Actions(driver).dragAndDropBy(slider, 400, 0).perform();
		
		

	}

}
