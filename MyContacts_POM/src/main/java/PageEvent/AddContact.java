package PageEvent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.AddContactElements;
import Util.ElementFetch;

public class AddContact {

	ElementFetch ele;
	WebDriver driver;

	// Constructor
	public AddContact(WebDriver driver) {
		this.driver=driver;
		this.ele=new ElementFetch(driver);
	}
	
	//Method to click on Addcontact Button
	public void AddContactBtn() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id("add-contact")));
		element.click();
	}

	// Methods to add contact
	public void addFName(String fname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.FName)));
		element.sendKeys(fname);
	}

	public void addLName(String lname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.LName)));
		element.sendKeys(lname);
	}

	public void addDOB(String dob) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.DOB)));
		element.sendKeys(dob);
	}

	public void addEmail(String email) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.Email)));
		element.sendKeys(email);
	}

	public void addPhone(String phone) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.Phone)));
		element.sendKeys(phone);
	}

	public void addAddress1(String address1) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.add1)));
		element.sendKeys(address1);
	}

	public void addAddress2(String address2) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.add2)));
		element.sendKeys(address2);
	}

	public void addCity(String city) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.city)));
		element.sendKeys(city);
	}

	public void addPostalCode (String postalCode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.postalcode)));
		element.sendKeys(postalCode);
	}

	public void addState(String stateProvince) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.State)));
		element.sendKeys(stateProvince);
	}

	public void addCountry(String country) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("ID", AddContactElements.country)));
		element.sendKeys(country);
		
	}

	public void submitMethod() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		element.click();
		System.out.println("data is entered successfully");
	}

	public void cancelAdding() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id("cancel")));
		element.click();
	}
	}

