package Util;

import java.time.Duration;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.baseTest;

public class ElementFetch {

	WebDriver driver;
	WebDriverWait wait;

	// constructor to initialize the driver
	public ElementFetch(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	// Fetch WebElement based on locators
	public WebElement getWebElement(String identifierType, String identifierValue){

		try {

			switch (identifierType) {
			case "XPATH":
				return baseTest.driver.findElement(By.xpath(identifierValue));

			case "CSS":
				return baseTest.driver.findElement(By.cssSelector(identifierValue));

			case "NAME":
				return baseTest.driver.findElement(By.name(identifierValue));

			case "ID":
				return baseTest.driver.findElement(By.id(identifierValue));

			case "TAGNAME":
				return baseTest.driver.findElement(By.tagName(identifierValue));

			case "LINKTEXT":
				return baseTest.driver.findElement(By.linkText(identifierValue));

			default:
				return null;

			}
		} catch (NoSuchElementException e) {
			System.out.println("Error: Element not Found" + identifierValue);
			throw new NoSuchElementException("Element not found:"+ identifierValue, e); // ensure the exception is propogated
			
		}

	}

	public List<WebElement> getWebElements(String identifierType, String identifierValue) {
		switch (identifierType) {
		case "XPATH":
			return baseTest.driver.findElements(By.xpath(identifierValue));

		case "CSS":
			return baseTest.driver.findElements(By.cssSelector(identifierValue));

		case "NAME":
			return baseTest.driver.findElements(By.name(identifierValue));

		case "ID":
			return baseTest.driver.findElements(By.id(identifierValue));

		case "TAGNAME":
			return baseTest.driver.findElements(By.tagName(identifierValue));

		case "LINKTEXT":
			return baseTest.driver.findElements(By.linkText(identifierValue));

		default:
			return null;

		}

	}
}
