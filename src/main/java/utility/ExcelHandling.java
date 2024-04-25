package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testBase.TestBase;

public class ExcelHandling extends TestBase{
//	public void readExcel() throws IOException  {
	
	public Object getCellValue(int sheetNum, int rowNum, int cellNum) throws IOException { // this method will be called with three string as parameters.
	Object strValue = null; // Initialize an object so that cell value is stored in it whether it is Integer or string.
		
		
	
	String path ="src\\test\\java\\testData\\Automation Test Cases.xlsx"; // File path of the excel sheet should start with "src" only.
	
	File file = new File(path);
    FileInputStream fis;
	try {
		fis = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		try {
			strValue = wb.getSheetAt(sheetNum).getRow(rowNum).getCell(cellNum).getStringCellValue();	// To get the string value		
		} catch (Exception e) {
			try {
				strValue = wb.getSheetAt(sheetNum).getRow(rowNum).getCell(cellNum).getNumericCellValue();			
				
			} catch (Exception e2) {
//				logger.info("Unable to get value from the Excel Sheet");
				e.printStackTrace();
			}
		}
	} catch (FileNotFoundException e) {
		
		logger.info("Error while handling Excel File");
		e.printStackTrace();
	}
	return strValue;
	
	
	
	
	
}}
