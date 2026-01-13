package com.blog.auto.initialization;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.blog.auto.browserconfiguration.browserConfig;
import com.blog.auto.configuration.configLoader;

public class setUpIntialization {

	protected static WebDriver driver;

	@BeforeClass
	public void browserOpen() {
		driver = browserConfig.browserSetup();
		driver.manage().window().maximize();
		driver.get(configLoader.getProperty("url"));
	}

	public static void captureScreenshot(String testName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("screenshots/" + testName + ".png");
		FileUtils.copyFile(src, destination);
	}

	@AfterClass
	public void browserClose() {
		if (driver != null) {
			driver.quit();
		}
	}
}
