// This class is to initalize the UI elements present on the website.


package pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

public class UIElement extends TestBase{
	
	public  UIElement() {
		PageFactory.initElements(driver,this);
	}
	
	
	
	
// Write xpaths and give their names in the below format
	
	
@FindBy(xpath="//button[id='button')") // write Xpath of webelement here	
private WebElement OkButton;  		// Name of the xpath
	  
public void clickOnOk ()		// This method to be called in the @test cases.
	{ 
  	OkButton.click(); // Selenium methods to perform operation on the WebElement.
	}

// Write xpaths and give action name in the above format 


//--------------------------------------------------------------------------
//--------------------------------------------------------------------------
// -----------------Write code below this line only ------------------------



//Click on Skip Tour
@FindBy(xpath="//button[text()='Skip Tour']") 
private WebElement skipTourBtn;  		
	  
public void clickonSkipTour()		
	{ 
	skipTourBtn.click();
	}
//=====================================================================
//Open Media
@FindBy(xpath="//a[@href='https://qa.archoral.com/media']") 
private WebElement OpenMedia;  		
	  
public void openMediaTab()		
	{ 
	OpenMedia.click();
	}
//=====================================================================
//Click on Upload
@FindBy(xpath="(//a[@href='https://qa.archoral.com/upload'])[1]") 
private WebElement UploadBtn;  		
	  
public void clickOnUpload()		
	{ 
	UploadBtn.click();
	}
//=====================================================================
//Upload file From computer
@FindBy(xpath="//input[@id='input-file-now']") 
private WebElement uploadBtn2;  		
	  
public void uploadFileFromTestData(String filePath)		
	{ 
	uploadBtn2.sendKeys(filePath);
	

//	upload.UploadFiles(filePath);
	}
//=====================================================================
// flipkart close first box


@FindBy(xpath="//button[text()='✕']") 
private WebElement flipkartCloseBtn;  		
	  
public void clickOnflipclose()		
	{ 
	flipkartCloseBtn.click();
	}
//=====================================================================
// become a seller click


@FindBy(xpath="//span[text()='Become a Seller']") 
private WebElement becomeSellerTab;  		
	  
public void clickOnbecomeSeller()		
	{ 
	becomeSellerTab.click();
	}















}
