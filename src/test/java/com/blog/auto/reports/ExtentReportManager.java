package com.blog.auto.reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getExtentReport() {

		if (extent == null) {

			String reportDir = System.getProperty("user.dir") + File.separator + "target" + File.separator
					+ "extent-report";

			// ✅ CREATE DIRECTORY (IMPORTANT)
			new File(reportDir).mkdirs();

			String reportPath = reportDir + File.separator + "ExtentReport.html";

			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

			spark.config().setReportName("Automation Test Report");
			spark.config().setDocumentTitle("Extent Report");

			extent = new ExtentReports();
			extent.attachReporter(spark);

			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Java", System.getProperty("java.version"));
		}
		return extent;
	}
}
