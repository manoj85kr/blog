package com.blog.auto.pagelocators;

public class Uploads {
	private static final String singleUpload = "//input[@type='file' and @id='singleFileInput']";
	private static final String multileUploads = "//input[@type='file' and @id='multipleFilesInput']";

	public static String getsingleUpload() {
		return singleUpload;
	}

	public static String getmultileUploads() {
		return multileUploads;
	}
}
