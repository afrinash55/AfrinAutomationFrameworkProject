 package Practice.Goal;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryTest implements IRetryAnalyzer {

    private int current_count = 0;
    private final int retry_count = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (current_count < retry_count) {
            current_count++;
            return true;
        }
        return false;
    }
}
