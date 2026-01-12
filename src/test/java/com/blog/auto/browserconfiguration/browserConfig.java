package com.blog.auto.browserconfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.blog.auto.configuration.configLoader;

public class browserConfig {

	public static WebDriver driver;

	public static WebDriver browserSetup() {
		String browser = configLoader.getProperty("browser");
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "ie":
			driver = new InternetExplorerDriver();
			break;

		default:
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		return driver;
	}
}
