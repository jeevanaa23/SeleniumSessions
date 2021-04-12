package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTables {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='smart-table table table-striped']/tbody/tr"));
		List<WebElement> cols=driver.findElements(By.xpath("//table[@class='smart-table table table-striped']/tbody/tr[1]/td"));
		for(int i=1;i<=rows.size();i++)
		{
			for(int j=1;j<=cols.size();j++) {
				System.out.println(driver.findElement(By.xpath("//table[@class='smart-table table table-striped']/tbody/tr["+i+"]/td["+j+"]")).getText());
			}
		}

	}

}
