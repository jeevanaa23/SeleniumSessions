package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Script {
	
	WebDriver driver;
	@Given("Open the Chrome Browser and start the application")
	public void open_the_Chrome_Browser_and_start_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Essentials\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
	}

	@When("Enter Valid Credentials and Submit")
	public void enter_Valid_Credentials_and_Submit() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("signin_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
	   
	}

	@Then("User should be logged in Successfully")
	public void user_should_be_logged_in_Successfully() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(driver.getTitle());
	   
	}

}
