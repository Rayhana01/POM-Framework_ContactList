package qa.test;

import org.testng.annotations.Test;

import Base.baseTest;
import PageEvent.SignUp;
import Util.ElementFetch;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestCase3 extends baseTest {
	
	WebDriver driver;
	ElementFetch ele;
	SignUp signup;
	
	//local variable creation 
	String fname;
	String lname;
	String email;
	String pass;
	
  @Test
  public void SignupMethod() {
	  
	  signup.signupButton(); 
	  signup.addFName(fname);
	  signup.addLastName(lname);
	  signup.addEmail(email);
	  signup.addPassword(pass);
	  signup.submitBtn();
	  System.out.println("User is created Successfully!");
	  signup.CancelBtn();
  }
  @BeforeClass
  public void beforeClass() {
	  
	  driver=getDriver();
	  ele=new ElementFetch(driver);
	  signup=new SignUp(driver);
	  
	  //variable initialization
	  fname="Jawahir";
	  lname="Khawar";
	  email="jawahir@hotmail.com";
	  pass="123456";
	    
  }

  @AfterClass
  public void afterClass() {
  }

}
