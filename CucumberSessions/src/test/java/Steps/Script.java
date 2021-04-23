package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Script {
	
	WebDriver driver;
	
	@Given("Open the Browser and enter Wikipedia")
	public void open_the_Browser_and_enter_Wikipedia() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://wikipedia.org");
		driver.manage().window().maximize();
	}

	@When("Type the search query and hit enter")
	public void type_the_search_query_and_hit_enter() {
	    driver.findElement(By.id("searchInput")).sendKeys("covid 19");
	    driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Then("Click on Talks")
	public void click_on_Talks() {
		System.out.println(driver.findElement(By.tagName("a")).getSize());
		driver.findElement(By.xpath("//li[@id='ca-talk']/a")).click();
	
	}
}
