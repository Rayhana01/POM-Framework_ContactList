package qa.test;

import org.testng.annotations.Test;
import Base.baseTest;
import PageEvent.LoginPage;
import Util.ElementFetch;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestCase1 extends baseTest {
	
	WebDriver driver;
	LoginPage login;
	ElementFetch ele;
	
	
  @Test
  public void EnteringCredentailMethod() {
	  
	  login.verifyLoginPageIsLoaded();
	  login.enterCredentials("ray@hotmail.com", "123cde90");
	  login.submit();
  }
  @BeforeClass
  public void beforeClass() {
	  
	  driver=getDriver();
	  login=new LoginPage(driver);
	  ele=new ElementFetch(driver);
	  
	  
	 
  }

  @AfterClass
  public void afterClass() {
	  
	 //driver.quit();
	  
  }

}
