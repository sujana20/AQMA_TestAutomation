package utility;

import java.io.IOException;
import java.util.ArrayList;
import testBase.TestBase;

public class ExcelLoop extends TestBase {
	public static ArrayList<String> testCaseName = new ArrayList<String>(); // Calling array from the excelHandlin class.



	public void testCaseList() {
		Object excelValue = null; // for the excel cell value which is testcase name
		Object decision = null; // for the excel cell value which is either "Yes" OR "No"
		ExcelHandling getValue = new ExcelHandling();
//        logger.info("ExcelHandling class Initialized");
		for (int i = 1; i<10;i++){
			
			
        try { // try/catch block to avoid if there is an error while handling excel
        	decision = getValue.getCellValue(0, i, 6);
			String decision2 = String.valueOf(decision); // Value of "Yes" or "No"
			
			if(decision2.equalsIgnoreCase("Yes")) { // If the value is yes then only the test case will be added for testing.
        	
				excelValue = getValue.getCellValue(0, i, 5);
				String excelValue2 = String.valueOf(excelValue);

				testCaseName.add(excelValue2); // Added value in the array of groups. This will be accessed in testngRunner class.
//				System.out.println(excelValue2); // to check if the value is correct
//				System.out.println("Testing value"); // to check if the value is correct
			
				}
			} catch (IOException e) { 
			break; // Break if there is no valid values coming or null values coming.
		}
        
        

		}
//		System.out.println(testCaseName);		// To check the array. This should include all the listed testcase names from the excel file which has "Yes" marked.
		
	}
	
}


