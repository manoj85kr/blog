package com.blog.auto.pagelocators;

public class Alerts {

	private static final String simpleAlert = "//button[@id='alertBtn']";
	private static final String confirmAlert = "//button[@id='confirmBtn']";
	private static final String promptAlert = "//button[@id='promptBtn']";
	private static final String newTab = "//button[contains(text(),'New Tab')]";
	private static final String popWindows = "//button[@id='PopUp']";

	public static String getsimpleAlert() {
		return simpleAlert;
	}

	public static String getconfirmAlert() {
		return confirmAlert;
	}

	public static String getpromptAlert() {
		return promptAlert;
	}

	public static String getnewTab() {
		return newTab;
	}

	public static String getpopWindows() {
		return popWindows;
	}
}
