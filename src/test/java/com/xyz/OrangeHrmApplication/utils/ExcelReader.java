package com.xyz.OrangeHrmApplication.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
public static Workbook wBook;
public static Sheet sheet;
	public static void openExcel(String filePath) {
		try {
			FileInputStream fis= new FileInputStream(filePath);
			 wBook= new XSSFWorkbook(fis);// will read the 
			//excel sheet with xlsx format
			//Workbook wBook1= new HSSFWorkbook(fis);// will read the 
			//excel sheet with xls format
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadSheet(String sheetName) {
		sheet=wBook.getSheet(sheetName);
	}
	
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
		
	}
	
	public static int columnCount(int rownum) {
		return sheet.getRow(rownum).getLastCellNum();
		
	}
	public static String cellData(int rowindex,int columnindex) {
		return sheet.getRow(rowindex).getCell(columnindex).toString();
		
	}
	//return a 2d object array of data
	
	public static Object[][] excelToArray(String filePath,String sheetName){
		
		openExcel(filePath);
		loadSheet(sheetName);
		int rowCount=rowCount();
		int columnCount=columnCount(0);
		Object[][] data= new Object[rowCount-1][columnCount];
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<columnCount;j++) {
				data[i-1][j]=	cellData(i,j);
			}
		}
		return data;
		
	}
	
}
