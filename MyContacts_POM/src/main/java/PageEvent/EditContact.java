package PageEvent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.baseTest;
import PageObject.EditContactElements;
import Util.ElementFetch;

public class EditContact extends baseTest {
	
	WebDriver driver;
	ElementFetch ele;
	
	
	public EditContact(WebDriver driver) {
		this.driver=driver;
		this.ele=new ElementFetch(driver);
	}
		

	public void editContact() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        // Wait for the table row to be visible and interactable
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tr.contactTableBodyRow")));
	        System.out.println("Element found: " + element.isDisplayed());

	        // Scroll the element into view using Actions class
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).perform(); // Scrolls the element into view
	        System.out.println("Element scrolled into view");

	        // Click the row
	        element.click();
	        System.out.println("Row clicked");

	        // Wait for the edit button to be visible and interactable
	        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EditContactElements.editBtn)));
	        System.out.println("Edit button found and interactable: " + editBtn.isDisplayed());

	        // Click the edit button
	        editBtn.click();
	        System.out.println("Edit button clicked");
	    } catch (Exception e) {
	        System.out.println("Error in editContact method: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	//method to edit contact details
	
	public void editcontactDetails(String name, String email2) {
		WebElement nameInput=ele.getWebElement("XPATH", EditContactElements.namefield);
		WebElement emailInput=ele.getWebElement("XPATH", EditContactElements.email);
		
		nameInput.click();
	    nameInput.sendKeys(Keys.CONTROL + "a"); // Select all text
	    nameInput.sendKeys(Keys.DELETE);       // Delete selected text
	    nameInput.sendKeys(name);              // Enter new name

		
	 // Clear the email field completely
	    emailInput.click();
	    emailInput.sendKeys(Keys.CONTROL + "a");
	    emailInput.sendKeys(Keys.DELETE);
	    emailInput.sendKeys(email2);           // Enter new email
		
		WebElement Submt=ele.getWebElement("XPATH", EditContactElements.Submit);
		Submt.click();
		
		WebElement ReturnCon=ele.getWebElement("XPATH", EditContactElements.returnConList);
		ReturnCon.click();
		
	}
	
}
