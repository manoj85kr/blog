package com.blog.auto.pagelocators;

public class StaticWebTable {

	private static final String tableRow = "//table[@name='BookTable']/tbody/tr";

	public static String gettableRow() {
		return tableRow;
	}
}
