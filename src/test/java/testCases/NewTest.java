package testCases;

import org.testng.annotations.Test;

public class NewTest extends testBase.TestBase {
	@Test 	(priority = 1)	
	public void AQMloginAccessTest() throws InterruptedException {
			
		loginAs.qa("admin", "12345678");
		logger.info("Logged in Successfully");
		takeScreenshot.save("SuccessfulLogin");
		logger.info("Logged in Successfully");
					
			}

}
