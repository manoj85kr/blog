package com.blog.auto.pages;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.blog.auto.pagelocators.Downloads;
import com.blog.auto.pagelocators.Dropdowns;
import com.blog.auto.utilities.HelperUtilities;
import com.blog.auto.utilities.TimeOutUnits;

public class DropdownPage {

	private WebDriver driver;
	HelperUtilities help = new HelperUtilities();

	public DropdownPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean selectColorFromTheDropDown() throws FileNotFoundException, InterruptedException {
		return help.selectValuesFromDropDown(driver, TimeOutUnits.getinSeconds(), "xpath", Dropdowns.getcolorDropDown(),
				"Red");
	}

	public boolean selectAnimalsFromTheDropDown() throws FileNotFoundException, InterruptedException {
		return help.selectValuesFromDropDown(driver, TimeOutUnits.getinSeconds(), "xpath",
				Dropdowns.getanimalsDropDown(), "Lion");
	}

	public boolean selectCountryFromTheDropDown() throws FileNotFoundException, InterruptedException {
		return help.selectValuesFromDropDown(driver, TimeOutUnits.getinSeconds(), "xpath",
				Dropdowns.getcountryDropDown(), "India");
	}

}
