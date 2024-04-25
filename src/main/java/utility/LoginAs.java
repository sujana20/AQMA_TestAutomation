package utility;

import testBase.TestBase;

public class LoginAs extends TestBase{
	
	public void qa(String email, String password) throws InterruptedException {
		driver.get("https://atlas.smartgeoapps.com/AQMServer/");
		Thread.sleep(500);
		login.enterUsername(email);
		login.enterPassword(password);
		login.clickOnLogin();
		Thread.sleep(1000);
		
		
	}

}
