package PageEvent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.baseTest;
import PageObject.loginPageElements;
import Util.ElementFetch;

public class InvalidLogin extends baseTest {
	
	WebDriver driver;
	ElementFetch ele;
	
	//constructor
	public InvalidLogin (WebDriver driver) {
		this.driver=driver;
		this.ele=new ElementFetch(driver);
	}

    // Method to verify the login page is loaded
    public void verifyLoginPageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginPageElements.submitButton)));
        Assert.assertTrue(ele.getWebElements("ID", loginPageElements.submitButton).size() > 0, "Element Not Found!");
    }

    // Method to enter credentials
    public void enterCredentials(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Enter username
        WebElement usernameField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id(loginPageElements.username))
        );
        usernameField.sendKeys(username);

        // Enter password
        WebElement passwordField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id(loginPageElements.password))
        );
        passwordField.sendKeys(password);
    }

    // Method to submit the login form
    public void submit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.id(loginPageElements.submitButton))
        );
        submitButton.click();
    }
    
	//methods to get error message
	public String getErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
	    return errorElement.getText();
	    
		
	}
}
