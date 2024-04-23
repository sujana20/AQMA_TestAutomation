// Class to create a Testng.xml file with java. This will be called in "RunAutomationSuite" class for execution.

package utility;

//import org.apache.log4j.Logger;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import testBase.TestBase;
import java.util.Arrays;

public class TestngRunner extends TestBase{
	static ExcelLoop excelLoop;
	static ExtentReporterNG extentReporter = new	ExtentReporterNG();
	static ListenersEx listeners = new ListenersEx();
//	static Logger logger;
	
	
    
	public void runSuite() throws InterruptedException {
		TestBase tb = new TestBase();  // Initialize testbase class to run logger. As logger is not initialized while running this class.
		tb.start();
		logger.info("Running TestCases Through Excel");
        TestNG testng = new TestNG();
        logger.info("Testng Initialized");
        
        testng.addListener(extentReporter); // Listeners added
        testng.addListener(listeners);
        logger.info("Listeners Added");
        

        
        XmlSuite suite = new XmlSuite(); // Create xml suite
        suite.setName("Excel Based Suite"); 
        logger.info("XmlSuite Created (Excel Based Suite)");
        
        XmlTest test = new XmlTest(suite);
        test.setName("Excel Based Regression Testing");

        
        XmlClass testClass = new XmlClass("testCases.TestCases"); 
        test.setXmlClasses(Arrays.asList(testClass));
        logger.info("TestClasses Initialized");
       
//        System.out.println(ExcelLoop.testCaseName.get(1));
        excelLoop = new ExcelLoop();
        excelLoop.testCaseList();
        for(int i=0;i<100;i++) {
        	try {
        String groupName = ExcelLoop.testCaseName.get(i);
        test.addIncludedGroup(groupName);
        	}catch(Exception e) {}
        }
//        test.addIncludedGroup("Regression");
        
        suite.setTests(Arrays.asList(test));

        
        testng.setXmlSuites(Arrays.asList(suite));
        testng.setOutputDirectory("test-Output-Programmatic"); 
        logger.info("Test output file created");

        
        testng.run();
        logger.info("TestngXml Executed Successfully. Check for any Console errors");
    }
}
