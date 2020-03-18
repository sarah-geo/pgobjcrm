package com.crmutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelTestData {
	
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFCell cell;
	
	
	
	 
	/* @Params - Excel path and sheet name*/
	 
	public static void setExcelFile(String path, String sheetName) {
		try {
			FileInputStream ExcelFile = new FileInputStream(path);		// open the excel file
			
			workbook = new XSSFWorkbook(ExcelFile);			// Access the excel sheet

			sheet = workbook.getSheet(sheetName);			// set sheet name
		//	cell= sheet.getRow(2).getCell(0);
		//	String cellData = cell.getStringCellValue();
		//	System.out.println("cellData" +cellData);


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	
	

	
	
	
	public static Object[][] getTestData(String sheetname){
		try {
			FileInputStream ExcelFile = new FileInputStream("E:\\eclipse-workspace\\crmpractice\\"
					+ "src\\main\\java\\com\\crmtestdata\\Testdata.xlsx");		// open the excel file
			
			workbook = new XSSFWorkbook(ExcelFile);			// Access the excel sheet

			sheet = workbook.getSheet(sheetname);			// set sheet name
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++)
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
		}
		
		
		
		
		
		return data;
		
	}

}
