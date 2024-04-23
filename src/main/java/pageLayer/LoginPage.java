// A seperate login page class. This is to initialize login related elements seperately.

package pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Login ID
		@FindBy(id = "UserName")
		private WebElement username;  		
			  
		public void enterUsername(String email)		
		 	{ 
			  	username.sendKeys(email);
		  	}
		//====================================================================
		//Password
		@FindBy(id = "Password")
		private WebElement password;  		
			  
		public void enterPassword(String pass)		
		 	{ 
			  	password.sendKeys(pass);
		  	}
		//=====================================================================
		//LoginButton Click
		@FindBy(xpath="//button[@class='btn btn-primary w-100']") 
		private WebElement loginButton;  		
			  
		public void clickOnLogin()		
			{ 
			loginButton.click();
			}
	//=====================================================================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//keep this brace
