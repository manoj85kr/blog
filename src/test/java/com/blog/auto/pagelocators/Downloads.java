package com.blog.auto.pagelocators;

public class Downloads {
	private static final String download = "//a[contains(text(),'Download Files')]";
	private static final String pdfTextBox = "//h2[contains(text(),'Download a Text or PDF File')]";
	private static final String pdfTextField = "//textarea";
	private static final String pdfTextGenerationButton = "//button[@id='generateTxt']";
	private static final String pdfTextGenerateDownloadLink = "//a[@id='txtDownloadLink']";

	public static String getdownload() {
		return download;
	}

	public static String getpdfTextBox() {
		return pdfTextBox;
	}

	public static String getpdfTextField() {
		return pdfTextField;
	}

	public static String getpdfTextGenerationButton() {
		return pdfTextGenerationButton;
	}

	public static String getpdfTextGenerateDownloadLink() {
		return pdfTextGenerateDownloadLink;
	}
}
