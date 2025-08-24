package Practice.Goal;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class TestListener implements ITestListener {
	

	 private static ExtentSparkReporter reporter;
	 private static ExtentReports extentReport;
	 private static ExtentTest test;

	static {//it is static and excutes once class is load(run)
	        reporter = new ExtentSparkReporter("extent_report.html");
	        extentReport = new ExtentReports();
	        extentReport.attachReporter(reporter);
	    }



    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        test = extentReport.createTest(result.getMethod().getMethodName());//its Create a new test entry or object for each testcase and decides whather it is pass or fail or skied
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        test.pass("Testcase passed successfully");
        try {
            
            WebDriver driver = ((BaseTest) result.getInstance()).driver;
            String path = Utilities.screenshot(driver, result.getName());
            System.out.println("Screenshot saved at: " + path);
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        test.fail("Testcase failed" +result.getThrowable());
    try {
        // ✅ Get driver from BaseTest (since all tests extend BaseTest)
        WebDriver driver = ((BaseTest) result.getInstance()).driver;
        /*result.getInstance() → gets the actual test class object that failed.
Example: if your test class is LoginTest, this returns that object.
(BaseTest) result.getInstance() → casts that object to BaseTest because all your test classes extend BaseTest.
.driver → accesses the driver field from BaseTest.
Now you have the same WebDriver instance used in the test that failed.*/

        // ✅ Call your Utilities.screenshot method
        String path = Utilities.screenshot(driver, result.getName());
        /*Calls your reusable screenshot method screenshot(WebDriver driver, String testname).
Passes:
driver → so Selenium knows which browser to capture.
result.getName() → gets the failed test method name (like Registration or loginTest).
Stores the returned screenshot file path (from Utilities.screenshot) in the path variable.*/
        System.out.println("Screenshot saved at: " + path);
        test.addScreenCaptureFromPath(path);

    } catch (Exception e) {
        System.out.println("Screenshot capture failed: " + e.getMessage());
    }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        test.skip("Testcase skipped");
    }

    
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
        extentReport.flush();  
    }
}
