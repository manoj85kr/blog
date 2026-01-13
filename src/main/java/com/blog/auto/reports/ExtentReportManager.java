package com.blog.auto.reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getExtentReport() {

		if (extent == null) {
			String reportPath = System.getProperty("user.dir")
			        + File.separator + "test-output"
			        + File.separator + "ExtentReport.html";

			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

			spark.config().setReportName("Automation Test Report");
			spark.config().setDocumentTitle("Extent Report");
			spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);

			extent = new ExtentReports();
			extent.attachReporter(spark);

			extent.setSystemInfo("Project", "Selenium Automation");
			extent.setSystemInfo("Tester", "Manoj");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Browser", "Chrome");
		}
		return extent;
	}
}
