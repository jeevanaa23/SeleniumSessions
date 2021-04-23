package katalonScripts;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Amazonautorecord {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://www.amazon.in/");
    driver.findElement(By.id("twotabsearchtextbox")).clear();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus nord");
    driver.findElement(By.id("nav-search-bar-form")).submit();
    driver.findElement(By.xpath("//img[@alt='OnePlus Nord 5G (Blue Marble, 12GB RAM, 256GB Storage)']")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
    driver.findElement(By.xpath("//button[@id='a-autoid-13-announce']/div/div[2]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | //button[@id='a-autoid-13-announce']/div/div[2] | ]]
    driver.findElement(By.id("add-to-cart-button")).click();
    driver.findElement(By.id("attach-close_sideSheet-link")).click();
    driver.findElement(By.xpath("//a[@id='nav_prefetch_yourorders']/span")).click();
    driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    driver.findElement(By.xpath("//div[@id='a-page']/div[2]/div/div[3]/div/a/div/div/div/div[2]/div/span")).click();
    driver.findElement(By.id("ap_password")).clear();
    driver.findElement(By.id("ap_password")).sendKeys("smilealot");
    driver.findElement(By.name("signIn")).submit();
    driver.findElement(By.id("ya-myab-plus-address-icon")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).clear();
    driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Jeevana");
    driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).clear();
    driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("9384510904");
    driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).clear();
    driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("624301");
    driver.findElement(By.xpath("//div[@id='a-page']/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='a-page']/div[2]")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).clear();
    driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("3/245,");
    driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).clear();
    driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("Rajiv Gandhi Nagar, By-pass Road");
    driver.findElement(By.id("address-ui-widgets-landmark")).click();
    driver.findElement(By.id("address-ui-widgets-landmark")).clear();
    driver.findElement(By.id("address-ui-widgets-landmark")).sendKeys("Gandhigram");
    driver.findElement(By.xpath("//span[@id='address-ui-widgets-addr-details-address-type-and-business-hours']/span/span/span")).click();
    driver.findElement(By.id("dropdown1_1")).click();
    driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
