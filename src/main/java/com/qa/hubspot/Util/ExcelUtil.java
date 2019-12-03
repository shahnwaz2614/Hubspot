package com.qa.hubspot.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.crypto.Data;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static String TestData_Sheet_Path="C:\\Users\\shahnwaz\\eclipse-workspace\\HubspotHybridFrameWork\\src\\main\\java\\com\\qa\\hubspot\\TestData\\HubSpotTestData.xlsx";

	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		
		try {
			FileInputStream fis=new FileInputStream(TestData_Sheet_Path);
			book=WorkbookFactory.create(fis);
			sheet=book.getSheet(sheetName);
			
			Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					
				}
			}
			return data;
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
