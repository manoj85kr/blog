package com.blog.auto.testscripts;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blog.auto.initialization.setUpIntialization;
import com.blog.auto.pages.DownloadPage;
import com.blog.auto.pages.DropdownPage;

public class DropDownTest extends setUpIntialization {
	@Test(groups = { "regression","common" })
	public void toVerifyColorValuesSelectedFromDropDown() throws FileNotFoundException, InterruptedException {
		DropdownPage dp = new DropdownPage(driver);
		boolean status = dp.selectColorFromTheDropDown();
		Assert.assertTrue(status);
	}

	@Test(groups = { "regression","common" })
	public void toVerifyAnimalsValuesSelectedFromDropDown() throws FileNotFoundException, InterruptedException {
		DropdownPage dp = new DropdownPage(driver);
		boolean status = dp.selectAnimalsFromTheDropDown();
		Assert.assertTrue(status);
	}

	@Test(groups = { "regression","common" })
	public void toVerifyCountryValuesSelectedFromDropDown() throws FileNotFoundException, InterruptedException {
		DropdownPage dp = new DropdownPage(driver);
		boolean status = dp.selectCountryFromTheDropDown();
		Assert.assertTrue(status);
	}

}
