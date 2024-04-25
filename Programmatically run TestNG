package utility;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import testBase.TestBase;

import java.util.Arrays;

public class TestNGProgrammaticExample extends TestBase{
	
	static ExtentReporterNG extentReporter = new	ExtentReporterNG();
	static ListenersEx listeners = new ListenersEx();
	
    
	public static void main(String[] args) {
        
        TestNG testng = new TestNG();

        
        testng.addListener(extentReporter);
        testng.addListener(listeners);
        

        
        XmlSuite suite = new XmlSuite();
        suite.setName("Suite2");

        
        XmlTest test = new XmlTest(suite);
        test.setName("Test2");

        
        XmlClass testClass = new XmlClass("testCases.TestCases"); 
        test.setXmlClasses(Arrays.asList(testClass));

        
        test.addIncludedGroup("Smoke");
        test.addIncludedGroup("Sanity");

        
        suite.setTests(Arrays.asList(test));

        
        testng.setXmlSuites(Arrays.asList(suite));
        testng.setOutputDirectory("test-Output-Programmatic"); 

        
        testng.run();
    }
}
