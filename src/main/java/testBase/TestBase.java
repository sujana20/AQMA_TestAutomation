package testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageLayer.LoginPage;
import pageLayer.UIElement;
import utility.GetCurrentDateTime;
import utility.LoginAs;
import utility.TakeScreenshots;
import utility.TestngRunner;



public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger;
	public static LoginPage login;
	public UIElement uielement;
	public TakeScreenshots takeScreenshot;
	public GetCurrentDateTime getCurrentDateTime;
	public TestngRunner testngRunner;
	public LoginAs loginAs;
	public WebDriverWait wait;
	 
	
		
	@BeforeClass (alwaysRun = true) // annotation added as @BeforeClass @BeforeMethod to be run before any test cases are running.
									// alwayRun attribute is added because when main method runs the suite then this methods are not running.
	public void start()  // This is to initialize logger. This method is executed first.
	{
		logger = Logger.getLogger("Frame1");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Logger Started");
	}
	
	
	@BeforeMethod (alwaysRun = true) // BeforeClass, BeforeMethod, AfterMethod, AfterClass
	public void setUp()
		{

		 String br = "chrome";        // Select Browser to run the Testcases     
		 if(br.equalsIgnoreCase("chrome"))
		{
			 	
			 ChromeOptions co = new ChromeOptions();
			 co.addArguments("--remote-allow-origins=*"); // Sometimes the chrome was not working.

			 WebDriverManager.chromedriver().clearDriverCache().setup();

			 WebDriverManager.chromedriver().setup();

			 driver = new ChromeDriver(co);
			 logger.info("Chrome launched"); 
		 }
		 else if (br.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 logger.info("Firefox launched"); 
		 }
		 else if(br.equalsIgnoreCase("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			 logger.info("Edge Browser launched"); 
		 }
		 else 
		 {
			 logger.info("Incorrect Browser name");
			 System.out.println("Enter valid browser name");
		 }
		 
		 driver.get("https://www.google.com");  
		 logger.info("url Loaded");
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		 logger.info("maximized Browser window and added waits");
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		 
		 
//		 com.qa.utility.ExcelHandling = new ExcelHandling();
		 login = new LoginPage();		// Initialize all the classes in TestBase before using them in src/test.
		 uielement = new UIElement(); 
		 testngRunner = new TestngRunner();
		 takeScreenshot = new TakeScreenshots();
		 getCurrentDateTime = new GetCurrentDateTime();
		 loginAs = new LoginAs();
		 
			
		 
		
		
	}
	
	@AfterMethod (alwaysRun = true) // To close the browser after testcase is completed
	public void TakeDown()
	{
		driver.quit();
		logger.info("Browser Closed");
	}
	@AfterClass (alwaysRun = true)
	public void stop() // Final executed method
	{
		logger.info("Automation Suite Executed Successfully");
	}
}