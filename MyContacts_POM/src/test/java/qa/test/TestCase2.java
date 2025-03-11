package qa.test;

import org.testng.annotations.Test;
import Base.baseTest;
import PageEvent.AddContact;
import PageEvent.LoginPage;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestCase2 extends baseTest {

	WebDriver driver;
	AddContact Contact;
	LoginPage login;

	// local variables
	String firstName;
	String lastName;
	String email;
	String phone;
	String birthdate;
	String city;
	String add1;
	String postalCode;
	String stateProvince;
	String country;

	public TestCase2() {
		// Default constructor
	}

	@Test
	public void InsertingContactDetail() {
		System.out.println("First Name: " + firstName);
	    Contact.addFName(firstName);

	    System.out.println("Last Name: " + lastName);
	    Contact.addLName(lastName);

	    System.out.println("Email: " + email);
	    Contact.addEmail(email);

	    System.out.println("Address: " + add1);
	    Contact.addAddress1(add1);

	    System.out.println("Phone: " + phone);
	    Contact.addPhone(phone);

	    System.out.println("DOB: " + birthdate);
	    Contact.addDOB(birthdate);

	    System.out.println("City: " + city);
	    Contact.addCity(city);

	    System.out.println("Postal Code: " + postalCode);
	    Contact.addPostalCode(postalCode);

	    System.out.println("State/Province: " + stateProvince);
	    Contact.addState(stateProvince);

	    System.out.println("Country: " + country);
	    Contact.addCountry(country);

	    Contact.submitMethod();
	}

	@BeforeClass
	public void beforeClass() {

		driver = getDriver();
		Contact = new AddContact(driver);
		login=new LoginPage(driver);
		
		//perform login
		login.verifyLoginPageIsLoaded();
		login.enterCredentials("ray@hotmail.com","123cde90");
		login.submit();
		
		Contact.AddContactBtn();
		Contact.submitMethod();

		// Initialize test data
		 	firstName = "Jawahir";
		    lastName = "Khawar";
		    email = "Jawahir@hotmail.com";
		    phone = "7899006";
		    birthdate = "May 2025";
		    city = "Sterling";
		    postalCode = "20166";
		    stateProvince = "VA";
		    country = "USA";
		    add1 = "Tiber Falls";
	}

	@AfterClass
	public void afterClass() {
	}

}
