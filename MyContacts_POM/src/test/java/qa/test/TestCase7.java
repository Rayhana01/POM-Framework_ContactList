package qa.test;

import org.testng.annotations.Test;

import Base.baseTest;
import PageEvent.InvalidLogin;
import Util.ElementFetch;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestCase7 extends baseTest{
	WebDriver driver;
	ElementFetch ele;
	InvalidLogin invalidlogin;
	
	
  @Test
  public void invalidloginMethod() {
	  
	  invalidlogin.verifyLoginPageIsLoaded();
	  invalidlogin.enterCredentials("ibrahim@hotmail.com", "123456");
	  invalidlogin.submit();
	  invalidlogin.getErrorMessage();
  }
  @BeforeClass
  public void beforeClass() {
	  
	  driver=getDriver();
	  invalidlogin=new InvalidLogin(driver); 
  }

  @AfterClass
  public void afterClass() {
  }

}
