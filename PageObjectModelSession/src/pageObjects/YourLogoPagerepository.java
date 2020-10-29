package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class YourLogoPagerepository {

	
	WebDriver driver;
	public YourLogoPagerepository() {
		this.driver=driver;
	}
    
	
	@FindBy(how=How.CLASS_NAME,using="login") WebElement signinlink;
	@FindBy(how=How.ID,using="email")WebElement emailid;
	@FindBy(how=How.NAME,using="passwd")WebElement password;
	@FindBy(how=How.XPATH,using="//button[@id='SubmitLogin']")WebElement signinButton;
	@FindBy(how=How.CLASS_NAME,using="logout")WebElement signoutLink;
	
	
	public void signInflow() {
		signinlink.click();
		emailid.sendKeys("oct1620201@yopmail.com");
		password.sendKeys("Passw0rd$123");
		signinButton.click();
	}
	
	public void signOutflow() {
		signoutLink.click();
	}
	
	
}
