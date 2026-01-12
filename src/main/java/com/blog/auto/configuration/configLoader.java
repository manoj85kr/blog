package com.blog.auto.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configLoader {
	static Properties pro = new Properties();
	static File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

	static {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getProperty(String Key) {
		return pro.getProperty(Key);
	}
}
