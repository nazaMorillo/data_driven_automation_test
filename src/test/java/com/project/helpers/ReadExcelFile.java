package com.project.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRichTextString;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public ReadExcelFile() {
		
	}
	
	public XSSFWorkbook createWorkbook (String filepath) throws IOException {
		
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);		
		XSSFWorkbook newWorkbook = new 	XSSFWorkbook(inputStream);
		
		return newWorkbook;
	}
	
	public XSSFSheet createSheet(String filepath, String sheetName) throws IOException {
		
		XSSFWorkbook newWorkbook = createWorkbook (filepath);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		newWorkbook.close();
		
		return newSheet;
	}
	
	public void readExcel(String filepath, String sheetName) throws IOException {
			
		XSSFSheet newSheet = createSheet(filepath, sheetName);
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
		
		for (int i = 0; i <= rowCount; i++) {
			XSSFRow row = newSheet.getRow(i);
			
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue() + "||");
			}			
		}
		//newWorkbook.close();
	}
	
	public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {
				
		XSSFSheet newSheet = createSheet(filepath, sheetName);
		XSSFRow row = newSheet.getRow(rowNumber);		
		XSSFCell cell = row.getCell(cellNumber);
		
		//newWorkbook.close();
		return cell.getStringCellValue();		
	}

}
