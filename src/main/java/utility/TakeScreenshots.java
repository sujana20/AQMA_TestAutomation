package utility;

import java.io.File;


import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import testBase.TestBase;


public class TakeScreenshots extends TestBase{
	static String path = "src\\test\\java\\testData\\Test Screenshots\\";
	
	public void save(String filename) {
		
		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver; // Using "TakesScreenshot" class to take screenshot
			File src = ts.getScreenshotAs(OutputType.FILE);
			String dateTime1 = GetCurrentDateTime.CurrentDateTime();
			File des = new File(path+filename+"_"+dateTime1+".png");
			FileHandler.copy(src, des);
			logger.info("Screenshot Taken");
			
		} catch (IOException e) {
		
			logger.info("Unable to Take Screenshot");
			e.printStackTrace();
		}
		
				
	}}
