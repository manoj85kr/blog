package com.blog.auto.pages;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.blog.auto.pagelocators.Alerts;
import com.blog.auto.pagelocators.Uploads;
import com.blog.auto.utilities.FileUtils;

public class UploadsPage {

	private WebDriver driver;

	public UploadsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean uploadSingleFile() {
		File file = FileUtils.getFileFromResources("30-Day-CSharp-Daily-Checklist.pdf");
		driver.findElement(By.xpath(Uploads.getsingleUpload())).sendKeys(file.getAbsolutePath());
		return true;
	}

	public boolean uploadMultipleFile() {
		File file1 = FileUtils.getFileFromResources("30-Day-CSharp-Daily-Checklist.pdf");
		File file2 = FileUtils.getFileFromResources("K.R.MANOJ  Lead Software Quality Assurance  13 years Experience In Automation  Selenium  Java  API.pdf");
		String files = file1.getAbsolutePath() + "\n" + file2.getAbsolutePath();
		driver.findElement(By.xpath(Uploads.getmultileUploads())).sendKeys(files);
		return true;
	}
}
