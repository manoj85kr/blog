package com.blog.auto.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blog.auto.initialization.setUpIntialization;
import com.blog.auto.pages.UploadsPage;

public class UploadsTest extends setUpIntialization {
	@Test(groups = { "prod", "common" })
	public void toVerifySingleUploads() {
		UploadsPage ap = new UploadsPage(driver);
		boolean status = ap.uploadSingleFile();
		Assert.assertTrue(status);
	}

	@Test(groups = { "prod", "common" })
	public void toVerifyMultipleUploads() {
		UploadsPage ap = new UploadsPage(driver);
		boolean status = ap.uploadMultipleFile();
		Assert.assertTrue(status);
	}
}
