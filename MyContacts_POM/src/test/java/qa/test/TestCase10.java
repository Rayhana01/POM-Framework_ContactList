package qa.test;

import org.testng.annotations.Test;

import Base.baseTest;
import PageEvent.LoginPage;
import PageEvent.logoutPage;
import Util.ElementFetch;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestCase10 extends baseTest {
	ElementFetch ele;
	logoutPage logout;
	LoginPage login;

	@Test
	public void logoutMethod() {

		logout.logoutMethod();

	}

	@BeforeClass
	public void beforeClass() {

		ele = new ElementFetch(driver);
		logout = new logoutPage();
		login = new LoginPage(driver);
		// perform login
		login.verifyLoginPageIsLoaded();
		login.enterCredentials("ray@hotmail.com", "123cde90");
		login.submit();
		logout.logoutMethod();

	}

	@AfterClass
	public void afterClass() {
	}

}
