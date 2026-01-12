package com.blog.auto.utilities;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileUtils {

	public static File getFileFromResources(String fileName) {
		try {
			InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(fileName);

			if (inputStream == null) {
				throw new RuntimeException("File not found in resources: " + fileName);
			}

			File tempFile = File.createTempFile("upload-", fileName);
			Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			tempFile.deleteOnExit();
			return tempFile;

		} catch (Exception e) {
			throw new RuntimeException("Unable to load file for upload", e);
		}
	}
}
