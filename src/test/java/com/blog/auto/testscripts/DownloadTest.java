package com.blog.auto.testscripts;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blog.auto.initialization.setUpIntialization;
import com.blog.auto.pages.DownloadPage;
import com.blog.auto.pages.UploadsPage;

public class DownloadTest extends setUpIntialization {
	@Test(groups = { "sanity", "common" }, enabled = false)
	public void toVerifyFileDownloaded() throws FileNotFoundException, InterruptedException {
		DownloadPage dp = new DownloadPage(driver);
		boolean status = dp.downloadFiles();
		Assert.assertTrue(status);
	}

}
