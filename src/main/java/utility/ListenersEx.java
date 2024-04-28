// Listeners for adding extra actions when the testcases are passed/failed/skipped
// Here screenshots are added when the test case is Passed or failed.

package utility;

import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.TestBase;

public class ListenersEx extends TestBase implements ITestListener {
	TakeScreenshots takeScreenshot = new TakeScreenshots();

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("TestCase Execution started_"+"("+result.getName()+")");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("TestCase Executed Successfully_"+"("+result.getName()+")");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("TestCase Execution Failed_"+"("+result.getName()+")");
        takeScreenshot.save("Failed_"+"("+result.getName()+")");
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test Case Skipped"+"("+result.getName()+")");
    }
}
