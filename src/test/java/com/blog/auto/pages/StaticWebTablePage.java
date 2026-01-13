package com.blog.auto.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.blog.auto.pagelocators.StaticWebTable;
import com.blog.auto.utilities.HelperUtilities;

public class StaticWebTablePage {
	private WebDriver driver;
	HelperUtilities help = new HelperUtilities();

	public StaticWebTablePage(WebDriver driver) {
		this.driver = driver;
	}

	public void tableData() {
		List<WebElement> rows = driver.findElements(By.xpath(StaticWebTable.gettableRow()));
		for (int i = 0; i < rows.size(); i++) {
			StringBuilder rowData = new StringBuilder();
			// Header row
			if (i == 0) {
				List<WebElement> headers = rows.get(i).findElements(By.tagName("th"));
				for (WebElement header : headers) {
					rowData.append(header.getText()).append(" | ");
				}
			}
			// Data rows
			else {
				List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
				for (WebElement col : cols) {
					rowData.append(col.getText()).append(" | ");
				}
			}
			System.out.println(rowData.toString());
		}
	}

}
