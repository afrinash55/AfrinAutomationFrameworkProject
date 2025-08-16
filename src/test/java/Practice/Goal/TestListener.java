package Practice.Goal;

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
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        test.fail("Testcase failed" +result.getThrowable());
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
