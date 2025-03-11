package qa.test;

import org.testng.annotations.Test;

import Base.baseTest;
import PageEvent.ContactList;
import PageEvent.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestCase4 extends baseTest {
	
	WebDriver driver;
	ContactList conlist;
	LoginPage login;
	String name;
	
  @Test
  public void ShowContactListMethod() {
	  
	  conlist.contactList(name);
  }
  @BeforeClass
  public void beforeClass() {
	  
	  driver=getDriver();
	  login=new LoginPage(driver);
	  conlist=new ContactList(driver);
	  
	//perform login
			login.verifyLoginPageIsLoaded();
			login.enterCredentials("ray@hotmail.com","123cde90");
			login.submit();

	
	//initialzie name 
	name="Rayhana Ibrahim";
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
