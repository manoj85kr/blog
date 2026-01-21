package com.blog.auto.testscripts;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import com.blog.auto.initialization.setUpIntialization;
import com.blog.auto.pages.StaticWebTablePage;

public class StaticWebPageTest extends setUpIntialization {
	@Test(groups = { "UAT","common" })
	public void toVerifyTableDataInStaticWebPage() throws FileNotFoundException, InterruptedException {
		StaticWebTablePage staticTable = new StaticWebTablePage(driver);
		staticTable.tableData();
	}

}
