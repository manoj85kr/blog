package com.blog.auto.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTest {

	@Test(dataProvider = "excelData")
	public void getData(Object[] rowData) throws IOException {
		System.out.println((int) Double.parseDouble(rowData[0].toString()));
		System.out.println((rowData[1].toString()));
	}

	@DataProvider(name = "excelData")
	public static Object[][] data() throws IOException {
		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "DataFile.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum(); // total rows excluding header
		int columnCount = sheet.getRow(0).getLastCellNum(); // total columns
		Object[][] data = new Object[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			for (int j = 0; j < columnCount; j++) {
				Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				data[i - 1][j] = cell.toString();
			}
		}
		workbook.close();
		fis.close();
		return data;
	}
}
