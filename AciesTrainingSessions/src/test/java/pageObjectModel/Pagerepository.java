package pageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pagerepository {
	WebDriver driver;
	
	public Pagerepository() {
		this.driver=driver;
	}
	
		 @FindBy(id="user-name") WebElement username;
		 @FindBy(id="password") WebElement pwd;
		 @FindBy(id="login-button") WebElement logbutton;
		 @FindBy(id="react-burger-menu-btn") WebElement menubar;
		 @FindBy(id="logout_sidebar_link") WebElement logout;

		 public void signin() {
			 username.sendKeys("standard_user");
			 pwd.sendKeys("secret_sauce");
			 logbutton.click();
		 }
		 
		 public void signout() {
			 menubar.click();
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 logout.click();
		 }
		 
}
