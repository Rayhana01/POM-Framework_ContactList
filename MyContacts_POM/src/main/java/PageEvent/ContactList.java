package PageEvent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.baseTest;
import PageObject.AddContactElements;
import Util.ElementFetch;

public class ContactList extends baseTest {
	
	WebDriver driver;
	AddContact  contact;
	ElementFetch ele;
	
	
	public ContactList(WebDriver driver) {
		this.driver=driver;
		this.ele=new ElementFetch(driver);
		
	}
	
	
	// method for displaying table content
		public boolean contactList(String name) {
		    // Locate the table
		    WebElement table = ele.getWebElement("XPATH", AddContactElements.ContactTable);

		    // Get all rows
		    List<WebElement> rows = table.findElements(By.tagName("tr"));

		    // Loop through rows
		    for (WebElement row : rows) {
		        // Get all cells in the row
		        List<WebElement> cells = row.findElements(By.tagName("td"));

		        // Loop through cells and check for the name
		        for (WebElement cell : cells) {
		            if (name.equals(cell.getText())) {
		                System.out.println("Name found: " + name);
		                return true;  // Exit immediately when found
		            }
		        }
		    }
		    System.out.println("Name not found: " + name);
		    return false; // Return false if name is not found
		}


}
