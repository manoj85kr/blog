package com.blog.auto.pages;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.blog.auto.pagelocators.Alerts;
import com.blog.auto.pagelocators.Uploads;

public class UploadsPage {

	private WebDriver driver;

	public UploadsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean uploadSingleFile() {
		driver.findElement(By.xpath(Uploads.getsingleUpload()))
				.sendKeys("E:\\Automation\\auto\\src\\test\\resources\\30-Day-CSharp-Daily-Checklist.pdf");
		return true;
	}

	public boolean uploadMultipleFile() {
		driver.findElement(By.xpath(Uploads.getmultileUploads())).sendKeys(
				"E:\\Automation\\auto\\src\\test\\resources\\30-Day-CSharp-Daily-Checklist.pdf\nE:\\Automation\\auto\\src\\test\\resources\\K.R.MANOJ  Lead Software Quality Assurance  13 years Experience In Automation  Selenium  Java  API.pdf");
		return true;
	}
}
