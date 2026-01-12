package com.blog.auto.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.blog.auto.pagelocators.Downloads;

public class DownloadPage {

	private WebDriver driver;

	public DownloadPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean downloadFiles() throws FileNotFoundException, InterruptedException {
		driver.findElement(By.xpath(Downloads.getdownload())).click();
		if (driver.findElement(By.xpath(Downloads.getpdfTextBox())).isDisplayed()) {
			driver.findElement(By.xpath(Downloads.getpdfTextField())).click();
			driver.findElement(By.xpath(Downloads.getpdfTextField())).sendKeys("Automation");
			driver.findElement(By.xpath(Downloads.getpdfTextGenerationButton())).click();
			driver.findElement(By.xpath(Downloads.getpdfTextGenerateDownloadLink())).click();
			Thread.sleep(2000);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertTrue(isFileDownloaded("info.txt", 10), "File was not downloaded");
		return true;
	}

	public boolean getFileFromDownloads() throws FileNotFoundException {
		boolean status = false;
		File file = new File("C:\\Users\\manoj\\Downloads\\info.txt");
		if (file.exists()) {
			status = true;
			file.delete();
		}
		return status;

	}

	public boolean isFileDownloaded(String fileName, int timeoutSeconds) {
		Path downloadPath = Paths.get("target/downloads/" + fileName);
		int waited = 0;

		while (waited < timeoutSeconds) {
			if (Files.exists(downloadPath)) {
				return true;
			}
			try {
				Thread.sleep(1000);
				waited++;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		return false;
	}

}
