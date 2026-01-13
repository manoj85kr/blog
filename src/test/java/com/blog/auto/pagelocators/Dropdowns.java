package com.blog.auto.pagelocators;

public class Dropdowns {
	private static final String colorDropDown = "//select[@id='colors']";
	private static final String animalsDropDown = "//select[@id='animals']";
	private static final String countryDropDown = "//select[@id='country']";

	public static String getcolorDropDown() {
		return colorDropDown;
	}

	public static String getanimalsDropDown() {
		return animalsDropDown;
	}

	public static String getcountryDropDown() {
		return countryDropDown;
	}
}
