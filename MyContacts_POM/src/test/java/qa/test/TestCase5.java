package qa.test;

import org.testng.annotations.Test;

import Base.baseTest;
import PageEvent.DeleteContact;
import PageEvent.LoginPage;
import Util.ElementFetch;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestCase5 extends baseTest {
	
	WebDriver driver;
	ElementFetch ele;
	LoginPage login;
	DeleteContact delcon;
	
	String ContactName;
	
  @Test (groups="regression")
  public void DeleteConMethod() {
	  
	  delcon.DeleteContactInfo(ContactName);
  }
  @BeforeClass
  public void beforeClass() {
	  
	  driver= getDriver();
	  ele=new ElementFetch(driver);
	  login= new LoginPage(driver);
	  delcon=new DeleteContact(driver);
	  
	//perform login
		login.verifyLoginPageIsLoaded();
		login.enterCredentials("ray@hotmail.com","123cde90");
		login.submit();
		
		ContactName="Nadia Hashimi";
  }

  @AfterClass
  public void afterClass() {
  }

}
