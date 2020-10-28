package testNGFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotationexperiments {
  @Test
  public void f() {
	  System.out.println("Printing Test");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Printing Before Method");
	  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Printing After Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Printing Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Printing After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Printing Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Printing After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Printing Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Printing After Suite");
  }

}
