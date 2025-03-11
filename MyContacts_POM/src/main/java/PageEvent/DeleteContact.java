package PageEvent;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.baseTest;
import PageObject.DeleteContactElements;
import Util.ElementFetch;

public class DeleteContact extends baseTest {
	
	WebDriver driver;
	ElementFetch ele;
	
	//Constructor
	public DeleteContact(WebDriver driver){
		this.driver=driver;
		this.ele=new ElementFetch(driver);	
	}
	
	public boolean DeleteContactInfo(String ContactName) {
		
        WebElement table = ele.getWebElement("XPATH", DeleteContactElements.Table);
        List<WebElement> rows = table.findElements(By.xpath("tr"));

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            if (columns.size() > 0 && columns.get(0).getText().equals(ContactName)) {
                WebElement deleteButton = columns.get(columns.size() - 1).findElement(By.tagName("button"));
                deleteButton.click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
                return true; // Contact successfully deleted
            }
            System.out.println("contact is deleted!!");
        }

        return false; // Contact not found
    }
}

