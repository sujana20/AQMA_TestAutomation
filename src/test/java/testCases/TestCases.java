package testCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases extends testBase.TestBase{


//========================================================================
//=========================================================================
//------------Write Test Cases below this line only----------------------
//========================================================================
		//Login
		@Test 	(priority = 1)	
		public void AQMloginAccessTest() throws InterruptedException {
				
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
						
				}
		
		
		//2.Dashboard ---//
		@Test 		(priority = 2)
		public void sideBarDashboard() throws InterruptedException {
				
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			
	        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
	        // Retrieve the text from the element and print it
	        String dashboardText = dashboardElement.getText();
	        logger.info("1st Menu option :" +dashboardText);
	        Thread.sleep(4000);
	        
	        //-----------------------------
						
				
		
		
		
		
		//2.1 Measurement Site Status (Text)
		
			
	        WebElement MeasurementSiteStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Measurement Site Status']")));
	        // Retrieve the text from the element and print it
	        String MeasurementSiteStatustext = MeasurementSiteStatus.getText();
	        logger.info("Table name : "+MeasurementSiteStatustext);
	        Thread.sleep(4000);

		
		
		
		//2.2 Validate Table Header Texts ------------------------//
	   
	    					
	    			
	        WebElement table = driver.findElement(By.className("jsgrid-table"));

	        List<WebElement> headerCells = table.findElements(By.cssSelector("tr th"));
	        String[] expectedHeaders = {
	        	    "Measurement Site",
	        	    "Station Label",
	        	    "Communication",
	        	    "Alarms",
	        	    "Failures",
	        	    "Last Data",
	        	    "Next Polling",
	        	    "Communication Status"
	        	    // Assuming the corrected sequence
	        	};

	        	if (headerCells.size() != expectedHeaders.length) {
	        		logger.info("Mismatch in the number of headers. Expected: " + expectedHeaders.length + ", but found: " + headerCells.size());
	        	} else {
	        	    for (int i = 0; i < headerCells.size(); i++) {
	        	        String actualHeaderText = headerCells.get(i).getText().trim();
	        	        if (!actualHeaderText.equalsIgnoreCase(expectedHeaders[i])) { // Using equalsIgnoreCase for case-insensitive comparison
	        	        	logger.info("Header mismatch found at position " + (i+1) + ": Expected '" + expectedHeaders[i] + "', found '" + actualHeaderText + "'");
	        	        } else {
	        	        	logger.info("Header " + (i+1) + " validated successfully: " + actualHeaderText);
	        	        }
	        	    }
	        	}
	        	Thread.sleep(4000);
	        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	        

	    
	    //2.3 Measurement site column ascending
	        
	        WebElement Msaascendings = driver.findElement(By.xpath("(//th[@class='jsgrid-header-cell jsgrid-header-sortable'])[1]"));
	        Msaascendings.click();
	        Thread.sleep(4000);
	        //---------------------------------------------------------------------


	         // Assuming you want to check the first column, locate all rows and then fetch the first cell from each row
//	        WebElement table = driver.findElement(By.className("jsgrid-table"));
	            List<WebElement> cells = table.findElements(By.cssSelector("tr td:nth-child(1)")); // Adjust the nth-child index based on the column you're checking
	            List<String> actualValues = new ArrayList<>();
	            for (WebElement cell : cells) {
	                actualValues.add(cell.getText().trim()); // Trim to remove any leading/trailing whitespace
	            }
	            // Copy and sort the list
	            List<String> sortedValues = new ArrayList<>(actualValues);
	            Collections.sort(sortedValues);

	            // Compare the original list with the sorted list
	            boolean isInAscendingOrder = actualValues.equals(sortedValues);
	            logger.info("Is the column in ascending order? : "  + isInAscendingOrder);
	            takeScreenshot.save("Dashboard");
	            logger.info("Dashboard working as expected");
	            //---------------------------------------------------------------------------------
	        }
		
		
		
		@Test 		(priority = 3)
		public void configuration() throws InterruptedException {
				
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
			
			//3. Configuration

            logger.info("------------------------------------------------------------");

            WebElement ConfigurationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Configuration']")));

            // Retrieve the text from the element and print it
            String ConfigurationText = ConfigurationElement.getText();
            logger.info("2nd Menu option :" + ConfigurationText);


            ConfigurationElement.click();
            logger.info(ConfigurationText + " Menu succesfully clicked ");


            Thread.sleep(6000);

            logger.info("------------------------------------------------------------");


            //------3.1 Station menu verification //--------


         // Retrieve the text from the element and print it
            WebElement stationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Station']")));

            // Retrieve the text from the element and print it
            String stationText = stationElement.getText();
            logger.info(" First Sub Menu under Configuration : " + stationText);
            stationElement.click();
            
            Thread.sleep(6000);

     //----------------------------------------------------------------
            WebElement stationListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Stations List']")));


         // Retrieve the text from the element and print it
            String stationListText = stationListElement.getText();
            logger.info(" Table Name : " + stationListText);
            stationElement.click();




          //-------------------------------------------------

            WebElement table2 = driver.findElement(By.className("jsgrid-table"));
            
            Thread.sleep(3000);

            List<WebElement> headerCells2 = table2.findElements(By.cssSelector("tr th"));

            String[] expectedHeaders2 = {
            	    "Station Name",
            	    "Description",
            	    "",



            	    // Assuming the corrected sequence
            	};

            	if (headerCells2.size() != expectedHeaders2.length) {
            	    logger.info("Mismatch in the number of headers. Expected: " + expectedHeaders2.length + ", but found: " + headerCells2.size());
            	} else {
            	    for (int i = 0; i < headerCells2.size(); i++) {
            	        String actualHeaderText2 = headerCells2.get(i).getText().trim();
            	        if (!actualHeaderText2.equalsIgnoreCase(expectedHeaders2[i])) { // Using equalsIgnoreCase for case-insensitive comparison
            	            logger.info("Header mismatch found at position " + (i+1) + ": Expected '" + expectedHeaders2[i] + "', found '" + actualHeaderText2 + "'");
            	        } else {
            	            logger.info("Header " + (i+1) + " validated successfully: " + actualHeaderText2);
            	        }
            	    }
            	}

            	  logger.info("------------------------------------------------------------");


            	  // Search icon



            	WebElement SearchIcon =  driver.findElement(By.xpath("//input[@class='jsgrid-button jsgrid-mode-button jsgrid-search-mode-button jsgrid-mode-on-button']"));


            	SearchIcon.click();

            	logger.info(" Stations List Search icon Clickable");


            	SearchIcon.click();


            //-------------------------Search box-----------------------//
            	Thread.sleep(8000);


            	WebElement statonNameSearchBox =  driver.findElement(By.xpath("(//input[@class='form-control form-control-sm'])[1]"));

            	statonNameSearchBox.click();
            	statonNameSearchBox.sendKeys("AL Zafran");

            	WebElement DescriptionSearchbox =  driver.findElement(By.xpath("(//input[@class='form-control form-control-sm'])[2]"));

            	Thread.sleep(2000);


            	DescriptionSearchbox.click();
            	DescriptionSearchbox.sendKeys("AL Zafran");


            	WebElement Searchsmallicon =  driver.findElement(By.xpath("//input[@class='jsgrid-button jsgrid-search-button']"));

            	Searchsmallicon.click();

            	logger.info("Stations List Search boxes are working as expected");


            	Thread.sleep(4000);
    //-----------------------------------------------------

     //Clear filter button

            WebElement ClearButton	= driver.findElement(By.xpath("//input[@class='jsgrid-button jsgrid-clear-filter-button']"));

            ClearButton.click();

            Thread.sleep(4000);

         logger.info("Stations List Clear Filter button working as expected");

            logger.info("-----------------------------------------------------------");
   //---------------------------------------------------------------------------------------------------------------------------------------------------------
		}
		
		

		@Test 		(priority = 4)
		public void Config_Device() throws InterruptedException {
				
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
			
			WebElement ConfigurationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Configuration']")));

            // Retrieve the text from the element and print it
            String ConfigurationText = ConfigurationElement.getText();
            logger.info("2nd Menu option :" + ConfigurationText);


            ConfigurationElement.click();
            logger.info(ConfigurationText + " Menu succesfully clicked ");


            Thread.sleep(7000);

            logger.info("------------------------------------------------------------");
			//--------------Device----------------------//
            //------3.2 sub menu verification //--------


         // Retrieve the text from the element and print it
            WebElement deviceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Device']")));

            // Retrieve the text from the element and print it
            String deviceText = deviceElement.getText();
            logger.info(" Second Sub Menu under Configuration : " + deviceText);
            deviceElement.click();

            WebElement deviceListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Devices List']")));


            // Retrieve the text from the element and print it
               String deviceListText = deviceListElement.getText();
               logger.info(" Table Name : " + deviceListText);
               deviceElement.click();



               WebElement table3 = driver.findElement(By.className("jsgrid-table"));

               List<WebElement> headerCells3 = table3.findElements(By.cssSelector("tr th"));

               String[] expectedHeaders3 = {
               	    "Station Name",
               	    "Device Name",
               	    "Device Model",
               	    "IP Address",
               	    "Port",
               	    "Type",
               	    "",

               	    // Assuming the corrected sequence
               	};

           	if (headerCells3.size() != expectedHeaders3.length) {
           	    logger.info("Mismatch in the number of headers. Expected: " + expectedHeaders3.length + ", but found: " + headerCells3.size());
           	} else {
           	    for (int i = 0; i < headerCells3.size(); i++) {
           	        String actualHeaderText3 = headerCells3.get(i).getText().trim();
           	        if (!actualHeaderText3.equalsIgnoreCase(expectedHeaders3[i])) { // Using equalsIgnoreCase for case-insensitive comparison
           	            logger.info("Header mismatch found at position " + (i+1) + ": Expected '" + expectedHeaders3[i] + "', found '" + actualHeaderText3 + "'");
           	        } else {
           	            logger.info("Header " + (i+1) + " validated successfully: " + actualHeaderText3);
           	        }
           	    }
           	}


           	WebElement SearchIcon2 =  driver.findElement(By.xpath("(//select[@class='form-select custom-select custom-select-sm'])[1]"));
        	SearchIcon2.click();

        	logger.info(" Stations List Search icon Clickable");


        	SearchIcon2.click();
        	
//        	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        	//--------------------drop down handle-----------------------------//


        	//station name drop down
        	
        	Thread.sleep(8000);

        	WebElement Dropdown = driver.findElement(By.xpath("(//select[@class='form-select custom-select custom-select-sm'])[1]"));
        	Dropdown.click();
        	Select dropdown = new Select(Dropdown);
        	dropdown.selectByIndex(1);
        	logger.info("Station Name Dropdown is working");


        	//Device name input box

        	WebElement Devicenameinputbox = driver.findElement(By.xpath("(//input[@class='form-control form-control-sm'])[1]"));

        	Devicenameinputbox.click();
        	Devicenameinputbox.sendKeys("Thermo 450i");

        	//Device model dropdown


            WebElement Dropdowndevicemodel = driver.findElement(By.xpath("(//select[@class='form-select custom-select custom-select-sm'])[2]"));

            Dropdowndevicemodel.click();
        	Select Dropdowndevicemodelselect = new Select(Dropdowndevicemodel);
        	Dropdowndevicemodelselect.selectByIndex(13);
        	logger.info("Device model Dropdown is working");

        	//IP Address input box

            WebElement ipAdressInputbox = driver.findElement(By.xpath("(//input[@class='form-control form-control-sm'])[2]"));

            ipAdressInputbox.click();
            ipAdressInputbox.sendKeys("192.168.1.45");


            //port input box

            WebElement portInputbox = driver.findElement(By.xpath("(//input[@class='form-control form-control-sm'])[3]"));

            portInputbox.click();
            portInputbox.sendKeys("502");


           //Type input box

            WebElement typeInputbox = driver.findElement(By.xpath("(//input[@class='form-control form-control-sm'])[4]"));

            typeInputbox.click();
            typeInputbox.sendKeys("Tcp/IP");



        	Thread.sleep(3000);

  //------------------------------------------------------------
        	logger.info("Config_Device working as expected");
        	logger.info("-----------------------------------------------------------");
			}
		
		
		
		@Test 		(priority = 5)
		public void configuration_parameter() throws InterruptedException {
			
			//Login in App
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
			
			//Click on Configuration and Parameter in Sidebar and validated Page Title
			//element which takes longer to load- wait code
			WebElement configurationMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Configuration']")));
			configurationMenu.click();
			WebElement parameterSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Parameter']")));
			parameterSubMenu.click();
			WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pagetitle']")));
			Assert.assertEquals("Parameters List", title.getText());
			takeScreenshot.save("Configuration_Parameters page");
			Thread.sleep(5000);
			
			//Validate Table Header
			try{
			SoftAssert softAssert = new SoftAssert();
			WebElement stationName = driver.findElement(By.xpath("(//table/tr/th)[1]"));
			softAssert.assertEquals("Station Name", stationName.getText(), "Column Name Mismatch");
			WebElement deviceName = driver.findElement(By.xpath("(//table/tr/th)[2]"));
			softAssert.assertEquals("Device Name", deviceName.getText(), "Column Name Mismatch");
			WebElement driverName = driver.findElement(By.xpath("(//table/tr/th)[3]"));
			softAssert.assertEquals("Driver Name", driverName.getText(), "Column Name Mismatch");
			WebElement parameterName = driver.findElement(By.xpath("(//table/tr/th)[4]"));
			softAssert.assertEquals("parameter Name", parameterName.getText(), "Column Name Mismatch");
			WebElement units = driver.findElement(By.xpath("(//table/tr/th)[5]"));
			softAssert.assertEquals("Units", units.getText(), "Column Name Mismatch");
			WebElement pollingInterval = driver.findElement(By.xpath("(//table/tr/th)[6]"));
			softAssert.assertEquals("Polling Interval", pollingInterval.getText(), "Column Name Mismatch");
			WebElement averageInterval = driver.findElement(By.xpath("(//table/tr/th)[7]"));
			softAssert.assertEquals("Average Interval", averageInterval.getText(), "Column Name Mismatch");
			
			//Error in soft assert will run catch block and display below message
			}catch(Exception e){
				logger.info("Error in Columns name");
				
			}
			
			//Select values from the dropdown ('Station name, Device name....')
			//Enter text in parameter Name field
			Thread.sleep(5000);
			WebElement selectStation = driver.findElement(By.xpath("(//section[@class='section']//td)[1]/select"));
			selectStation.click();
			Thread.sleep(1000);
			
			WebElement selectStationValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//section[@class='section']//td)[1]//option[text()='Ghadfan North']")));
			selectStationValue.click();
			Thread.sleep(500);
			//--
			WebElement deviceNameDropdown = driver.findElement(By.xpath("(//section[@class='section']//td)[2]/select"));
			deviceNameDropdown.click();
			Thread.sleep(500);
			
			WebElement selectDeviceValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//section[@class='section']//td)[2]//option[text()='Thermo 55i'])[1]")));
			selectDeviceValue.click();
			//-
			WebElement driverNameDropdown = driver.findElement(By.xpath("(//section[@class='section']//td)[3]/select"));
			driverNameDropdown.click();
			Thread.sleep(500);
			
			WebElement selectDriverValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//section[@class='section']//td)[3]//option[text()='TOTAL HC']")));
			selectDriverValue.click();
				
			WebElement enterParameterName = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
			enterParameterName.sendKeys("TCH");
			
			WebElement unitsNameDropdown = driver.findElement(By.xpath("(//section[@class='section']//td)[5]/select"));
			unitsNameDropdown.click();
			Thread.sleep(500);
	
			WebElement selectUnitsValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//section[@class='section']//td)[5]//option[@value='27']"))); 
			// Later 
			// Match the filtered list with entered value // add asserts
			selectUnitsValue.click();
			
			//Click Search and take screenshot
			WebElement clickSearchButton = driver.findElement(By.xpath("//input[@title='Search']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(clickSearchButton).click().perform();
			takeScreenshot.save("Config_Parameter Search");
			
			//Click Clear filter and take screenshot
			WebElement clickFilterButton = driver.findElement(By.xpath("//input[@title='Clear filter']"));
			clickFilterButton.click();
			takeScreenshot.save("Config_Parameter Clear Filter");
			
			}
		
		
		@Test 		(priority = 6)
		public void configuration_Grouping() throws InterruptedException {
				
			//Login
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
			
			
			WebElement configurationMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Configuration']")));
			configurationMenu.click();
			WebElement parameterSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Grouping-SubPanel")));
			parameterSubMenu.click();
			WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pagetitle']")));
			Assert.assertEquals("Group List", title.getText());
			takeScreenshot.save("Configuration_Grouping page");
			Thread.sleep(5000);
			
			//Validate Table Header
			SoftAssert softAssert = new SoftAssert();
			WebElement id = driver.findElement(By.xpath("(//table/tr/th)[1]"));
			softAssert.assertEquals("ID", id.getText(), "Column Name Mismatch");
			WebElement groupName = driver.findElement(By.xpath("(//table/tr/th)[2]"));
			softAssert.assertEquals("Group Name", groupName.getText(), "Column Name Mismatch");			
			softAssert.assertAll();//If single soft assert is failed then whole test case will fail
			
			//Enter values for applying the filter
			Thread.sleep(1500);
			WebElement enterId = driver.findElement(By.xpath("(//table//td/input)[1]"));
			enterId.sendKeys("5");
			WebElement enterGroupName = driver.findElement(By.xpath("(//table//td/input)[2]"));
			enterGroupName.sendKeys("group1");
			
			//Click search and Take Screenshot
			WebElement clickSearchButton = driver.findElement(By.xpath("//input[@title='Search']"));
			clickSearchButton.click();
			takeScreenshot.save("Config_Grouping Search");
			
			//Validate the values which are populating after the filter is applied
			WebElement groupResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//table[@class='jsgrid-table'])[2]//tr/td)[1]")));
			groupResult.getText();
			Assert.assertEquals("5", groupResult.getText());
			WebElement groupResult2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//table[@class='jsgrid-table'])[2]//tr/td)[2]")));
			groupResult2.getText();
			Assert.assertEquals("group1", groupResult2.getText());
			
			//Clear Filter 
			Thread.sleep(1000);
			WebElement clickFilterButton = driver.findElement(By.xpath("//input[@title='Clear filter']"));
			clickFilterButton.click();
			takeScreenshot.save("Config_Grouping Clear Filter");
			}
		
		
		
		
		@Test 		(priority = 7)
		public void configuration_Grouping_AddGroup() throws InterruptedException {
				
			//Login as QA
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
			
			//Navigate to respective page and validatate page
			WebElement configurationMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Configuration']")));
			configurationMenu.click();
			WebElement parameterSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Grouping-SubPanel")));
			parameterSubMenu.click();
			WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pagetitle']")));
			Assert.assertEquals("Group List", title.getText());
			Thread.sleep(3000);
			takeScreenshot.save("Configuration_Grouping page");
			
			WebElement addGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add']")));
			addGroup.click();
			Thread.sleep(2000);
			WebElement addGroupTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pagetitle']")));
			Assert.assertEquals("Add Group", addGroupTitle.getText());
			takeScreenshot.save("Configuration_Grouping_Add Group page");
			WebElement clickToggle = driver.findElement(By.xpath("(//ol/li)[1]/span/button[@title='Toggle']"));
			clickToggle.click();
			WebElement selectCheckbox1 = driver.findElement(By.xpath("((//ol/li)[1]//span[@class='rct-icon rct-icon-uncheck'])[1]"));
			selectCheckbox1.click();
			takeScreenshot.save("Add Group");
			
		}
		
		@Test 		(priority = 8)
		public void admin_Users() throws InterruptedException {
			
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
			
			WebElement adminMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
			adminMenu.click();
			WebElement usersSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Users']")));
			usersSubMenu.click();
			WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pagetitle']")));
			Assert.assertEquals("Users List", title.getText());
			Thread.sleep(3000);
			
			SoftAssert softAssert = new SoftAssert();
			WebElement userName = driver.findElement(By.xpath("(//table/tr/th)[1]"));
			softAssert.assertEquals("User Name", userName.getText(), "Column Name Mismatch");
			WebElement userEmail = driver.findElement(By.xpath("(//table/tr/th)[2]"));
			softAssert.assertEquals("User Email", userEmail.getText(), "Column Name Mismatch");			
			softAssert.assertAll();
			WebElement role = driver.findElement(By.xpath("(//table/tr/th)[2]"));
			softAssert.assertEquals("User Email", role.getText(), "Column Name Mismatch");			
			softAssert.assertAll();
			takeScreenshot.save("Admin_Users page");
			
			WebElement inputUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table/tr/td/input[@type='text'])[1]")));
			inputUsername.sendKeys("AQMS_user");
			WebElement inputUseremail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table/tr/td/input[@type='text'])[2]")));
			inputUseremail.sendKeys("aqms@aimsgt.com");
			WebElement inputRole = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table/tr/td/input[@type='text'])[3]")));
			inputRole.sendKeys("Guest");
			WebElement clickSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table/tr/td/input)[4]")));
			clickSearch.click();
			logger.info("Search Validated");
			takeScreenshot.save("Filter Applied on Users List");
			
			WebElement getFilteredUsername= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='jsGrid jsgrid']/div)[2]/table//td)[1]")));
			Assert.assertEquals("AQMS_user", getFilteredUsername.getText());
			WebElement getFilteredUseremail= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='jsGrid jsgrid']/div)[2]/table//td)[2]")));
			Assert.assertEquals("aqms@aimsgt.com", getFilteredUseremail.getText());
			WebElement getFilteredRole= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='jsGrid jsgrid']/div)[2]/table//td)[3]")));
			Assert.assertEquals("Guest", getFilteredRole.getText());
			
			WebElement clickResetFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table/tr/td/input)[5]")));
			clickResetFilter.click();
			logger.info("Filter Click Validated");
			takeScreenshot.save("Clear Filter of Users List");
			
		}
		
		
		@Test 		(priority = 9)
		public void admin_addusers() throws InterruptedException {
			
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
			
			WebElement adminMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
			adminMenu.click();
			WebElement usersSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Users']")));
			usersSubMenu.click();
			
			WebElement clickOnCreateUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Create New User']")));
			clickOnCreateUser.click();
			WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pagetitle']")));
			Assert.assertEquals("Add User", title.getText());
			Thread.sleep(1500);
			takeScreenshot.save("Add users page");
			
			//Create new User
			WebElement enterUsername = driver.findElement(By.id("username"));
			enterUsername.sendKeys("test User Name");
			WebElement enterUseremail = driver.findElement(By.id("useremail"));
			enterUseremail.sendKeys("testmail@test.com");
			WebElement enterPassword = driver.findElement(By.id("password"));
			enterPassword.sendKeys("password");
			WebElement selectUserGroup = driver.findElement(By.xpath("(//select[@id='usergroup']/option)[2]"));
			selectUserGroup.click();
			WebElement selectUserRole = driver.findElement(By.xpath("(//select[@id='userrole']/option)[2]"));
			selectUserRole.click();
			takeScreenshot.save("Add user form filled");
			
		}
		
		
		@Test		(priority = 10)
		public void admin_usersLog() throws InterruptedException {
			
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
			
			WebElement adminMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
			adminMenu.click();
			WebElement usersSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Users Log-SubPanel")));
			usersSubMenu.click();
			
			WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pagetitle']")));
			Assert.assertEquals("Users Log List", title.getText());
			Thread.sleep(3000);
			
			WebElement selectUserName = driver.findElement(By.xpath("(//div/div/div/div)[1]/p"));
			selectUserName.click();
			try {
			WebElement selectUserDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='optWrapper selall multiple']/p")));
			selectUserDropdown.click();
			}catch(Exception e) {
				WebElement selectUserDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='optWrapper selall multiple']/select")));
				selectUserDropdown.click();
			}
			WebElement selectFromDate = driver.findElement(By.xpath("(//div/div/div/div)[1]"));
			selectFromDate.sendKeys("01/02/2024");
			
			WebElement clickSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[1]")));
			clickSearch.click();
			takeScreenshot.save("Clicked on Search");
			
			WebElement selectUsernameDropdown = driver.findElement(By.xpath("(//table[@class='jsgrid-table']/tr)[2]/td/select"));
			selectUsernameDropdown.click();
			Thread.sleep(2000);
			WebElement selectDropdownValue = driver.findElement(By.xpath("((//table[@class='jsgrid-table']/tr)[2]/td/select/option)[3]"));
			selectDropdownValue.click();
			WebElement clickSearchButton = driver.findElement(By.xpath("//input[@title='Search']"));
			clickSearchButton.click();
			Thread.sleep(2000);
			takeScreenshot.save("Users Log List Filter Applied"); //Screenshot not Taken
			WebElement clickResetButton = driver.findElement(By.xpath("//input[@title='Clear filter']"));
			clickResetButton.click();
			takeScreenshot.save("Users Log List Reset Filter");
			
			
		}
		@Test		(priority = 11)
		public void admin_ApplicationLog() throws InterruptedException {
			
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
		
			WebElement adminMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
			adminMenu.click();
			WebElement ApplicationSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Application Log-SubPanel")));
			ApplicationSubMenu.click();
			logger.info("Clicked on Application Log");
		
		
			WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pagetitle']")));
			Assert.assertEquals("Application Log List", title.getText());
			Thread.sleep(3000);
			logger.info("Validated Title");
			
			WebElement selectFromDate = driver.findElement(By.xpath("(//input[@id='fromdateid'])[1]"));
			selectFromDate.sendKeys("01/02/2024");
			WebElement clickSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-primary mx-1'])[1]")));
			clickSearch.click();
			Thread.sleep(5000);
			takeScreenshot.save("Clicked on Filter");
			logger.info("Clicked on Filter");
		}
		
		@Test		(priority = 12)
		public void admin_UserGroup() throws InterruptedException {
			
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			takeScreenshot.save("SuccessfulLogin");
			
			WebElement adminMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
			adminMenu.click();
			WebElement ApplicationSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Users Group-SubPanel")));
			ApplicationSubMenu.click();
			logger.info("Clicked on Users Group");
			Thread.sleep(3000);
			
			WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pagetitle']")));
			Assert.assertEquals("User's Group List", title.getText());
			Thread.sleep(3000);
			logger.info("Validated Title");
			
			Thread.sleep(3000);
			SoftAssert softAssert = new SoftAssert();
			WebElement userName = driver.findElement(By.xpath("(//table/tr/th)[1]"));
			softAssert.assertEquals("User Name", userName.getText(), "Column Name Mismatch");
			WebElement Permission = driver.findElement(By.xpath("(//table/tr/th)[2]"));
			softAssert.assertEquals("Permission", Permission.getText(), "Column Name Mismatch");			
			softAssert.assertAll();
			
			WebElement enterUserName = driver.findElement(By.xpath("(//input[@class='form-control form-control-sm'])[1]"));
			enterUserName.sendKeys("Admin");
			logger.info("Admin value passed ");
			
			WebElement Searchsmallicon =  driver.findElement(By.xpath("(//input[@class='jsgrid-button jsgrid-search-button'])[1]"));
        	Searchsmallicon.click();
        	logger.info("User's Group List Search boxes are working as expected");

			
		}
		
		@Test		(priority = 13)
		public void admin_createNewGroup() throws InterruptedException {
			
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			//takeScreenshot.save("SuccessfulLogin");
			
			WebElement adminMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
			adminMenu.click();
			WebElement ApplicationSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Users Group-SubPanel")));
			ApplicationSubMenu.click();
			logger.info("Clicked on Users Group");
			Thread.sleep(3000);
			
			WebElement createNewGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Create New Group']")));
			createNewGroup.click();
			logger.info("Clicked on Create New Group");
			Thread.sleep(3000);
			takeScreenshot.save("Successfuly landed on Create New Group page ");
			
		}	
		
		@Test		(priority = 14)
		public void Reports_PredefinedCharts() throws InterruptedException {
			
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			
		 driver.findElement(By.id("Reports-Panel")).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Predefined Charts-SubPanel"))).click();
		 driver.findElement(By.cssSelector("#no2radio")).click();
		 logger.info("Clicked on NO2");
		 takeScreenshot.save("Successfuly Clicked on NO2 ");
		 Thread.sleep(4000);  //60sec, 60000 ms
		 
		 driver.findElement(By.cssSelector("#so2radio")).click(); 
		 logger.info("Clicked on SO2");
		 takeScreenshot.save("Successfuly Clicked on SO2 ");
		 Thread.sleep(4000);
		 
		 driver.findElement(By.cssSelector("#o3radio")).click(); 
		 logger.info("Clicked on O3");
		 takeScreenshot.save("Successfuly Clicked on O3 ");
		 Thread.sleep(4000);
		 
		 driver.findElement(By.cssSelector("#pm10radio")).click(); 
		 logger.info("Clicked on PM10");
		 takeScreenshot.save("Successfuly Clicked on PM10 ");
		 Thread.sleep(4000);
		 
		 driver.findElement(By.cssSelector("#coradio")).click();  
		 logger.info("Clicked on CO");
		 takeScreenshot.save("Successfuly Clicked on CO");
		 Thread.sleep(4000);

		 driver.findElement(By.xpath("//*[@id=\"main\"]/div/section/div/div/div[3]/div/button[1]")).click();
		 logger.info("Clicked on Download Image");
		 Thread.sleep(4000);
		  
		 driver.findElement(By.xpath("//*[@id=\"main\"]/div/section/div/div/div[3]/div/button[2]")).click();
		 logger.info("Clicked on Download Pdf");
		}
		
		@Test		(priority = 15)
		public void Reports_DetailedAnalysisReports() throws InterruptedException {
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			
			WebElement reportsPanel = wait.until(ExpectedConditions.elementToBeClickable(By.id("Reports-Panel")));
		    reportsPanel.click();

		    // Click on Detailed Analysis Report-SubPanel
		    WebElement detailedAnalysisReportSubPanel = wait.until(ExpectedConditions.elementToBeClickable(By.id("Detailed Analysis Report-SubPanel")));
		    detailedAnalysisReportSubPanel.click();
		    Thread.sleep(5000);
		   

		    // Select station
		    WebElement stationDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#stationid")));
		    Select station = new Select(stationDropdown);
		    station.selectByVisibleText("SPIC Building");
		    logger.info("SPIC Building selected ");

		    // Select parameter
		    WebElement parameterDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pollutentid")));
		    Select parameter = new Select(parameterDropdown);
		    parameter.selectByVisibleText("O3");
		    logger.info("parameter selected ");

		    // Click on the button to generate the report
		    WebElement generateReportButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > section > div > div > div.card > div > div > div.mt-3 > button")));
		    generateReportButton.click();
		    Thread.sleep(8000);
		    logger.info("Clicked on generate report ");
		    takeScreenshot.save("Detailed Analysis Report is working as expected");

		    // Scroll down
		    Actions scroll = new Actions(driver);
		    scroll.sendKeys(Keys.PAGE_DOWN).build().perform();
		    Thread.sleep(6000);

		    // Click on the first button
		    WebElement firstButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/section/div/div/div[2]/div[2]/button[1]")));
		    firstButton.click();
		    Thread.sleep(2000);
		    logger.info("Clicked on Download Image ");

		    // Click on the second button
		    WebElement secondButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/section/div/div/div[2]/div[2]/button[2]")));
		    secondButton.click();
		    logger.info("Clicked on Download Pdf ");
			
		}
		
		@Test		(priority = 16)
		public void Reports_StatisticalReports() throws InterruptedException {
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			
			driver.findElement(By.id("Reports-Panel")).click();
			Thread.sleep(3000);
			 
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Statistical Reports-SubPanel"))).click();	
			 
			 WebElement stationdropdown = driver.findElement(By.xpath("//span[text()='Select Station']"));
			 stationdropdown.click();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='SPIC Building']"))).click();
				logger.info("Station Selected ");
				Thread.sleep(3000);
	
			 WebElement parameterropdown = driver.findElement(By.xpath("//span[text()='Select Parameter']"));	
			 parameterropdown.click();
			 WebElement clickOnDropdownValue = driver.findElement(By.xpath("//label[text()='O3']"));	
			 clickOnDropdownValue.click();
			 WebElement clickOnDropdownValue2 = driver.findElement(By.xpath("//label[text()='CO']"));	
			 clickOnDropdownValue2.click();
			 logger.info("parameter Selected");
			 Thread.sleep(3000);
				  
				  
			 WebElement intervaldropdown = driver.findElement(By.cssSelector("#intervalid"));
			 Select interval = new Select(intervaldropdown);
			 interval.selectByVisibleText("15-M");
			 logger.info("interval Selected");
			 Thread.sleep(3000);
				  
			  
			driver.findElement(By.xpath("//button[text()='Generate Chart']")).click();
			
			try {
			    WebElement element = driver.findElement(By.xpath("//canvas[@role='img']"));
			    if (element.isDisplayed()) {
			    	Thread.sleep(1000);
			    	Actions actions = new Actions(driver);
					WebElement downloadButton = driver.findElement(By.xpath("//button[text()='Download as Image']"));
					actions.moveToElement(downloadButton).perform();
			    	takeScreenshot.save("Reports_StatisticalReports");
			    	logger.info("Chart Generated Successfully");
			    	downloadButton.click();
			    	Thread.sleep(2000);
			    } else {
			       logger.info("Failed to generate Chart");
			       Assert.assertEquals(false, true);
			    }
			} catch (NoSuchElementException e) {
			    logger.info("Failed to validated Chart");
			}	
		}		
		
		@Test		(priority = 17)
		public void Reports_ExceedenceReport() throws InterruptedException {
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			
			//Exceedence Reports
			
					driver.findElement(By.id("Reports-Panel")).click();			 
					driver.findElement(By.id("Exceedence Report-SubPanel")).click();
			
			 
					WebElement stationdropdown = driver.findElement(By.cssSelector("#stationid"));
					Select station = new Select(stationdropdown);
					station.selectByVisibleText("SPIC Building");
					logger.info("Station Selected ");
		     
					WebElement parameterropdown = driver.findElement(By.cssSelector("#pollutentid"));
					Select parameter = new Select(parameterropdown);
					parameter.selectByVisibleText("SO2");
					logger.info("parameter Selected ");
				  
				  
					WebElement Units = driver.findElement(By.cssSelector("#unitid"));
					Select Unitsd = new Select(Units);
					Unitsd.selectByVisibleText("PPB");
					logger.info("Units Selected ");
			  
					WebElement selectFromDate = driver.findElement(By.xpath("(//input[@id='fromdateid'])[1]"));
					selectFromDate.sendKeys("01/02/2024");
					logger.info("date Selected ");
			        
			    
			      	WebElement intervaldropdown = driver.findElement(By.id("intervalid"));
			      	Select interval = new Select(intervaldropdown);
			      	interval.selectByVisibleText("1-H");
				  
			  
			      	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			      	logger.info("Clicked on Generate Report ");
			      	Thread.sleep(10000);
				  
				  
			      	driver.findElement(By.xpath("//button[@class='btn btn-primary mx-1 datashow']")).click();
			      	logger.info("Clicked on Download Pdf ");
			      	logger.info("ExceedenceReport Working as expected ");
			      	takeScreenshot.save("Successfuly Taken Screenshot ");
			      		
		}
		
		@Test		(priority = 17)
		public void Reports_WindRose() throws InterruptedException {
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			
			driver.findElement(By.id("Reports-Panel")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("WindRose-SubPanel")).click();	
			Thread.sleep(3000);
			
			WebElement stationdropdown = driver.findElement(By.cssSelector("#stationid"));
			Select station = new Select(stationdropdown);
	        station.selectByVisibleText("SPIC Building");
	        logger.info("Station Selected");
	        Thread.sleep(5000);


	        WebElement selectFromDate = driver.findElement(By.xpath("//input[@id='fromdateid']"));
			selectFromDate.sendKeys("01/02/2024");
			logger.info("date Selected ");


			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			logger.info("clicked on Generate Report");
			takeScreenshot.save("Successfuly Taken Screenshot");
			Thread.sleep(6000);

			//driver.findElement(By.xpath("//button[contains(text(),'Download as Image')]")).click();
			//logger.info("clicked on Download as Image");
			//Thread.sleep(2000);
			
			//driver.findElement(By.xpath("(//button[@class='btn btn-primary mx-1'])[2]")).click();
			//logger.info("clicked on Download as Pdf");
			logger.info("WindRose working as Expected");
		
		}	
		
		@Test		(priority = 18)
		public void Reports_DataValidation() throws InterruptedException {
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
						
			driver.findElement(By.id("Reports-Panel")).click();
			driver.findElement(By.id("Data Validation-SubPanel")).click();
	 			
			Thread.sleep(2000);
			WebElement stationdropdown = driver.findElement(By.id("stationid"));			
			Select station = new Select(stationdropdown);
	        station.selectByVisibleText("SPIC Building");
	        logger.info("Station Selected");
	        Thread.sleep(3000);

			driver.findElement(By.xpath("//span[text()='Select Parameter']")).click();
			driver.findElement(By.xpath("//label[text()='Select All']")).click();	
			WebElement fromdate = driver.findElement(By.id("fromdateid"));
			fromdate.click();
			fromdate.clear();
			Thread.sleep(5000);
			fromdate.click();
			Thread.sleep(5000);
			fromdate.sendKeys("03/05/2024");
			
			

			WebElement enddate = driver.findElement(By.id("todateid"));
			enddate.click();
			enddate.clear();
			Thread.sleep(5000);
			enddate.click();
			enddate.sendKeys("2024-02-24"); 

			WebElement intervaldropdown = driver.findElement(By.id("criteriaid"));
			Select interval = new Select(intervaldropdown);
			interval.selectByVisibleText("15-M");

			driver.findElement(By.xpath("//*[@id=\"getdata\"]")).click();
			Thread.sleep(3000);

			/*Actions scroll = new Actions(driver);
			scroll.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(5000);
			WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/section/div/div/div[3]/div[2]/button[1]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			WebElement element1 = driver.findElement(By.xpath("//*[@id=\"main\"]/section/div/div/div[3]/div[2]/button[2]"));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(element1).click().perform();
			takeScreenshot.save("Reports_DataValidation");*/
			}
		
		@Test		(priority = 18)
		public void Reports_LiveData() throws InterruptedException {
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
			

			driver.findElement(By.id("Reports-Panel")).click();
			driver.findElement(By.id("Livedata-SubPanel")).click();
			logger.info("Live Data Selected");
			
			Thread.sleep(50000);
			takeScreenshot.save("Successfuly Taken Screenshot");
			
		}
		
		@Test		(priority = 19)
		public void Reports_DataBrowsing() throws InterruptedException {
			loginAs.qa("admin", "12345678");
			logger.info("Logged in Successfully");
						
			driver.findElement(By.id("Reports-Panel")).click();
			driver.findElement(By.id("Data Browsing-SubPanel")).click();
	 			
			Thread.sleep(2000);
			WebElement stationdropdown = driver.findElement(By.id("stationid"));			
			Select station = new Select(stationdropdown);
	        station.selectByVisibleText("SPIC Building");
	        logger.info("Station Selected");
	        Thread.sleep(3000);

			driver.findElement(By.xpath("//span[text()='Select Parameter']")).click();
			driver.findElement(By.xpath("//label[text()='Select All']")).click();	
			WebElement fromdate = driver.findElement(By.id("fromdateid"));
			fromdate.click();
			fromdate.clear();
			fromdate.sendKeys("2024-02-01"); 
			WebElement enddate = driver.findElement(By.id("todateid"));
			enddate.click();
			enddate.clear();
			enddate.sendKeys("2024-02-24"); 

			WebElement intervaldropdown = driver.findElement(By.id("criteriaid"));
			Select interval = new Select(intervaldropdown);
			interval.selectByVisibleText("15-M");

			driver.findElement(By.xpath("//*[@id=\"getdata\"]")).click();
			Thread.sleep(3000);
			
			/*driver.findElement(By.xpath("//button[text()='Download Excel']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Download Csv']")).click();
			Thread.sleep(2000);*/

			/*Actions scroll = new Actions(driver);
			scroll.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(5000);
			WebElement element = driver.findElement(By.xpath("//button[text()='Download as Image']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			WebElement element1 = driver.findElement(By.xpath("//button[text()='Download as Pdf']"));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(element1).click().perform();
			takeScreenshot.save("Reports_DataBrowsing");
			Thread.sleep(3000);*/
			}

		
}
