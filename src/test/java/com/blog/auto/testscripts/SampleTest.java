package com.blog.auto.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.blog.auto.initialization.setUpIntialization;

public class SampleTest extends setUpIntialization {

//	@Test(groups = { "inherit" })
//	public void inherit1() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit2() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit3() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit4() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit5() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit6() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit7() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit8() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit9() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit10() {
//		System.out.println("Sample10");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit11() {
//		System.out.println("Sample11");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit12() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit13() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit14() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit15() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit16() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit17() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit18() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit19() {
//		System.out.println("Sample");
//	}
//
//	@Test(groups = { "inherit" })
//	public void inherit20() {
//		System.out.println("Sample");
//	}
//
//	@Parameters({ "first-name" })
//	@Test()
//	public void parameters(String firstName) {
//		System.out.println(firstName);
//	}
//
//	@DataProvider(name = "Testing")
//	public Object[][] data() {
//		return new Object[][] { { "Manoj", 46 }, { "Saranya", 36 } };
//	}
//
//	@Test(dataProvider = "Testing")
//	public void values(String val, int nam) {
//		System.out.println(val);
//		System.out.println(nam);
//	}

	@Test(dataProvider = "excelData")
	public void getDataFromExcel(Map<String, String> data) {
		for (Entry<String, String> d : data.entrySet()) {
			String[] headers = d.getKey().split("\n");
			for (int i = 0; i < headers.length; i++) {
				System.out.print(headers[i] + "|");
			}
		}
	}

	@DataProvider(name = "excelData")
	public Object[][] getExcelData() throws Exception {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "test" + File.separator + "resources" + File.separator + "DataFile.xlsx");

		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);

		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rows - 1][1]; // ✅ ONE object per row

		// Read header row
		Row headerRow = sheet.getRow(0);

		for (int i = 1; i < rows; i++) {

			Row row = sheet.getRow(i);
			Map<String, String> rowData = new HashMap<>();

			for (int j = 0; j < cols; j++) {

				String header = headerRow.getCell(j).getStringCellValue();
				Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

				rowData.put(header, cell.toString());
			}

			data[i - 1][0] = rowData; // ✅ Map as single argument
		}

		wb.close();
		fis.close();

		return data;
	}

}
