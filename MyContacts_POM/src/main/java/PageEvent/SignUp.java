package PageEvent;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObject.SignUpPageElements;
import Util.ElementFetch;

public class SignUp {

	ElementFetch ele;
	WebDriver driver;

	// Constructor
	public SignUp(WebDriver driver) {
		this.driver = driver;
		this.ele = new ElementFetch(driver);

	}
	
	//click on Signup Button first 
	public void signupButton () {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement signupButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignUpPageElements.SignUpButton)));
		signupButton.click();		
	}
	
	public void addFName (String fname) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement UserName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignUpPageElements.FirstName)));
		UserName.sendKeys(fname);		
	}
	
	
	public void addLastName (String lname) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement UserName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignUpPageElements.LastName)));
		UserName.sendKeys(lname);		
	}
	
	
	public void addEmail (String email) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement UserName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignUpPageElements.Email)));
		UserName.sendKeys(email);		
	}
	
	
	
	public void addPassword(String pass) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement PassField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignUpPageElements.Password)));
		PassField.sendKeys(pass);
	}

	public void submitBtn() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement subButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SignUpPageElements.SubmitBtn)));
		subButton.click();
		
	}
	
	public void CancelBtn() {
		WebDriverWait wait=new WebDriverWait (driver,Duration.ofSeconds(10));
		WebElement CanButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SignUpPageElements.CanBtn)));
		CanButton.click();
	}
}
