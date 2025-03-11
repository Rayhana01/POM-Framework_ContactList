package qa.test;

import org.testng.annotations.Test;

import Base.baseTest;
import PageEvent.LoginPage;
import PageEvent.returnConlist;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestCase8 extends baseTest {
	
	WebDriver driver;
	LoginPage login;
	returnConlist conlist;
	
  @Test
  public void returnConlistMethod() throws TimeoutException, InterruptedException {
	  
	  conlist.tableRowSel(1);
	  //conlist.returnToCL();
  }
  @BeforeClass
  public void beforeClass() {
	  
	  driver=getDriver();
	  login=new LoginPage(driver);
	  conlist=new returnConlist(driver);
	  
		//perform login
		login.verifyLoginPageIsLoaded();
		login.enterCredentials("ray@hotmail.com","123cde90");
		login.submit();
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
