package PageEvent;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.ElementFetch;

public class logoutPage {

	ElementFetch ele;
	WebDriver driver;

	public void logoutMethod() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			// Ensure the page is fully loaded
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));

			// Handle iframe if necessary
			driver.switchTo().defaultContent();
			List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			if (!iframes.isEmpty()) {
				driver.switchTo().frame(0); // Switch if required
			}

			// Verify logout button exists
			List<WebElement> logoutButtons = driver.findElements(By.id("logout"));
			if (logoutButtons.isEmpty()) {
				throw new NoSuchElementException("Logout button not found");
			}

			// Click logout button
			WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout")));
			logoutBtn.click();

			System.out.println("Logout successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
