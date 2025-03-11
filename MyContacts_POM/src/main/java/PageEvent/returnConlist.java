package PageEvent;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.baseTest;
import Util.ElementFetch;

public class returnConlist extends baseTest {

	WebDriver driver;
	ElementFetch ele;

	// Constructor
	public returnConlist(WebDriver driver) {
		this.driver = driver;
		this.ele = new ElementFetch(driver);
	}

	public void tableRowSel(int rowIndex) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Ensure the table is visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myTable")));
	    driver.manage().window().maximize();

	    // Get all table rows
	    List<WebElement> rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	        By.xpath("//table[@id='myTable']//tr")
	    ));

	    System.out.println("Table row count: " + rows.size());

	    // Validate row index
	    if (rowIndex >= rows.size()) {
	        throw new RuntimeException("Invalid row index: " + rowIndex + ". Total rows: " + rows.size());
	    }

	    WebElement row = rows.get(rowIndex);

	    // Scroll to the row and click
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", row);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", row);

	    // Wait for "Back to Contact List" button to be visible and clickable
	    WebElement backToCL = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("return")));
	    wait.until(ExpectedConditions.elementToBeClickable(backToCL)).click();

	    // Wait for table to reappear
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myTable")));
	}



	
}
