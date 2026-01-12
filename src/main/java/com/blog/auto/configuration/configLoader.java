package com.blog.auto.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configLoader {
	static Properties pro = new Properties();
	// static File file = new File(System.getProperty("user.dir") +
	// "\\src\\test\\resources\\config.properties");

	static {
		try {
			InputStream input = configLoader.class.getClassLoader().getResourceAsStream("config.properties");

			if (input == null) {
				throw new RuntimeException("config.properties not found in classpath");
			}

			pro.load(input);
		} catch (Exception e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}
//	static {
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			pro.load(fis);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static String getProperty(String Key) {
		return pro.getProperty(Key);
	}
}
