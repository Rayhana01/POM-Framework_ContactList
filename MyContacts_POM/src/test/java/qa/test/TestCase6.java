package qa.test;

import org.testng.annotations.Test;

import Base.baseTest;
import PageEvent.EditContact;
import PageEvent.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestCase6 extends baseTest {
	
	WebDriver driver;
	LoginPage login;
	EditContact editcon;
  @Test
  public void EditContactMethod() {
	  
	  editcon.editContact();
  }
  @BeforeClass
  public void beforeClass() {
	  
	  driver=getDriver();
	  login=new LoginPage(driver);
	  editcon=new EditContact(driver);
	  
		//perform login
		login.verifyLoginPageIsLoaded();
		login.enterCredentials("ray@hotmail.com","123cde90");
		login.submit();
  }

  @AfterClass
  public void afterClass() {
  }

}
