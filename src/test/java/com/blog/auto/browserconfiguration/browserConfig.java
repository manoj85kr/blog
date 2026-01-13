package com.blog.auto.browserconfiguration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.blog.auto.configuration.configLoader;

public class browserConfig {

	public static WebDriver driver;

	public static WebDriver browserSetup() {
		String browser = configLoader.getProperty("browser");
		switch (browser) {
		case "chrome":
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("download.default_directory", System.getProperty("user.dir") + "/target/downloads");
			prefs.put("download.prompt_for_download", false);
			ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
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
