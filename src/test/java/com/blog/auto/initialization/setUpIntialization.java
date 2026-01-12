package com.blog.auto.initialization;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.blog.auto.browserconfiguration.browserConfig;
import com.blog.auto.configuration.configLoader;

public class setUpIntialization {

	protected WebDriver driver;

	@BeforeClass
	public void browserOpen() {
		driver = browserConfig.browserSetup();
		driver.manage().window().maximize();
		driver.get(configLoader.getProperty("url"));
	}

	@AfterClass
	public void browserClose() {
		if (driver != null) {
			driver.quit();
		}
	}
}
