package com.blog.auto.utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUtilities {

	public boolean SetImplicitWait(WebDriver driver, long timeouts) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
			return true;
		} catch (Exception e) {
			System.err.println("Failed to set implicit wait: " + e.getMessage());
			return false;
		}
	}

	public By locatorStruct(String locators, String locatorPath) {
		if (locators == null || locatorPath == null) {
			throw new IllegalArgumentException("Locator type or value cannot be null");
		}
		switch (locators) {
		case "xpath":
			return By.xpath(locatorPath);
		case "id":
			return By.id(locatorPath);
		case "name":
			return By.name(locatorPath);
		case "css":
		case "cssselector":
			return By.cssSelector(locatorPath);
		case "classname":
			return By.className(locatorPath);
		case "tagname":
			return By.tagName(locatorPath);
		case "linktext":
			return By.linkText(locatorPath);
		case "partiallinktext":
			return By.partialLinkText(locatorPath);
		default:
			throw new IllegalArgumentException("Invalid locator type provided: " + locators);
		}
	}

	public boolean setExplicitWaitForElementClickable(WebDriver driver, long timeoutInSeconds, String locatorType,
			String locatorPath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.elementToBeClickable(locatorStruct(locatorType, locatorPath)));
			return true;
		} catch (TimeoutException e) {
			System.err.println("Element not clickable within " + timeoutInSeconds + " seconds");
			return false;
		}
	}

	public boolean setExplicitWaitForElementSelected(WebDriver driver, long timeoutInSeconds, String locatorType,
			String locatorPath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.elementToBeSelected(locatorStruct(locatorType, locatorPath)));
			return true;
		} catch (TimeoutException e) {
			System.err.println("Element not Selectable within " + timeoutInSeconds + " seconds");
			return false;
		}
	}

	public boolean setExplicitWaitForInvisiblityOfElement(WebDriver driver, long timeoutInSeconds, String locatorType,
			String locatorPath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locatorStruct(locatorType, locatorPath))));
			return true;
		} catch (TimeoutException e) {
			System.err.println("Element not invisible within " + timeoutInSeconds + " seconds");
			return false;
		}
	}

	public boolean setExplicitWaitForPresenceOfElement(WebDriver driver, long timeoutInSeconds, String locatorType,
			String locatorPath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(locatorStruct(locatorType, locatorPath)));
			return true;
		} catch (TimeoutException e) {
			System.err.println("Element is not Presenced within " + timeoutInSeconds + " seconds");
			return false;
		}
	}

	public Alert SetExplicitWaitForAlertPresent(WebDriver driver, long timeouts) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public boolean clickElement(WebDriver driver, long timeoutInSeconds, String locatorType, String locatorPath,
			int retryCount) {
		for (int attempt = 1; attempt <= retryCount; attempt++) {
			try {
				return setExplicitWaitForElementClickable(driver, timeoutInSeconds, locatorType, locatorPath);
			} catch (StaleElementReferenceException | ElementClickInterceptedException | TimeoutException e) {
				System.out.println("Click retry " + attempt + " failed");
			}
		}
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(locatorStruct(locatorType, locatorPath)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean selectValuesFromDropDown(WebDriver driver, long timeoutInSeconds, String locatorType,
			String locatorPath, String selectionText) {
		try {
			Select selection = new Select(driver.findElement(locatorStruct(locatorType, locatorPath)));
			selection.selectByVisibleText(selectionText);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
