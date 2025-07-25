package com.app.filehandles;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {
	Map<String,String> data =  new HashMap<String,String>();
	
public Map<String,String> getExcelData(String sheetname, String dsid)  {
		
		try {
		
		String filePath = System.getProperty("user.dir")+"/DataFiles/TestData.xlsx";
		
		File file = new File(filePath);
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		XSSFRow Keyrow = sheet.getRow(0);
		
		int rowCount = sheet.getLastRowNum();
		
		int coloumCount = Keyrow.getLastCellNum();
		
		int rownum = 0;
		
		for(int i=1; i<rowCount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			if(dsid.equalsIgnoreCase(row.getCell(0).getStringCellValue())) {
			
			rownum=i;
			break;
		}
		
		}	
		XSSFRow valueRow = sheet.getRow(rownum);
		
		for(int i=0; i<coloumCount; i++) {
			
			String Key = Keyrow.getCell(i).getStringCellValue();
			
			String value = valueRow.getCell(i).getStringCellValue();
			
			data.put(Key, value);
		}
		
	}catch (Exception e){
		
		e.printStackTrace();
	}
		return data;
		
	}

}
