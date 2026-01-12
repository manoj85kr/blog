package com.blog.auto.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.blog.auto.initialization.setUpIntialization;
import com.blog.auto.pages.AlertsPage;

public class AlertsTest extends setUpIntialization {

	@Test
	public void toVerifyClickActionOnAlerts() {
		AlertsPage ap = new AlertsPage(driver);
		boolean status = ap.clickAlerts();
		Assert.assertTrue(status);
	}

	@Test
	public void toVerifyConfirmActionOnAlerts() {
		AlertsPage ap = new AlertsPage(driver);
		boolean status = ap.confirmAlerts();
		Assert.assertTrue(status);
	}

	@Test
	public void toVerifyPromptActionOnAlerts() throws InterruptedException {
		AlertsPage ap = new AlertsPage(driver);
		String status = ap.promptAlerts();
		Assert.assertEquals(status, "Hello Manoj! How are you today?");
	}

	@Test
	public void switchTabs() throws InterruptedException {
		AlertsPage ap = new AlertsPage(driver);
		String status = ap.switchTabs();
		Assert.assertEquals(status, "Automation Testing Practice");
	}

	@Test
	public void switchPopWindows() throws InterruptedException {
		AlertsPage ap = new AlertsPage(driver);
		String status = ap.switchTabs();
		Assert.assertEquals(status, "Automation Testing Practice");
	}
}
