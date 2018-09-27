package com.bb.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bb.qa.base.TestBase;





public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	//Search Items variables
	public static String TESTDATA_SHEET_PATH = "C:/Users/Diana's/workspace/BestBuyTesting/src/main/java/com/bb/qa/testdata/searchItems.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	//Select Description variables
	public static String TESTDATA_SHEET_PATH_DESCRIPTION = "C:/Users/Diana's/workspace/BestBuyTesting/src/main/java/com/bb/qa/testdata/descriptionItems.xlsx";
	static Workbook book_description;
	static Sheet sheet_description;
	
	
	//Search Items file method
	public static Object[][] getTestSearchItems(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
			for(int i = 0; i < sheet.getLastRowNum(); i++) {				
				data[i][0] = sheet.getRow(i).getCell(0).toString();
			
			}
		
		return data;
	}
	

	//Select description file method
	public static Object[][] getTestDescriptionItems(String sheetName) {
		FileInputStream file_description = null;
		try {
			file_description = new FileInputStream(TESTDATA_SHEET_PATH_DESCRIPTION);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book_description = WorkbookFactory.create(file_description);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet_description = book_description.getSheet(sheetName);
		Object[][] data = new Object[sheet_description.getLastRowNum()][sheet_description.getRow(0).getLastCellNum()];
	
			for(int i = 0; i < sheet_description.getLastRowNum(); i++) {				
				data[i][0] = sheet_description.getRow(i).getCell(0).toString();
			
			}
		
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	
}
