package com.blog.auto.pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.blog.auto.pagelocators.Alerts;

public class AlertsPage {

	private WebDriver driver;

	public AlertsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean clickAlerts() {
		driver.findElement(By.xpath(Alerts.getsimpleAlert())).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		return true;
	}

	public boolean confirmAlerts() {
		driver.findElement(By.xpath(Alerts.getconfirmAlert())).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		return true;
	}

	public String promptAlerts() throws InterruptedException {
		driver.findElement(By.xpath(Alerts.getpromptAlert())).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Manoj");
		alert.accept();
		return driver.findElement(By.xpath("//p[@id='demo']")).getText();
	}

	public String switchTabs() throws InterruptedException {
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath(Alerts.getnewTab())).click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentwindow)) {
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parentwindow);
		return driver.getTitle();
	}

	public String switchPopWindows() throws InterruptedException {
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath(Alerts.getpopWindows())).click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentwindow)) {
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
				driver.manage().window().maximize();
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parentwindow);
		return driver.getTitle();
	}
}
