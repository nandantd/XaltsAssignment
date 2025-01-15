package GenericLibrary;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersMethods extends Baseclass implements ITestListener {
    private ExtentReports extent = extentReports.getReportobject();
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        logFailureDetails(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No implementation needed
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result); // Log failure details for timeout
    }

    @Override
    public void onStart(ITestContext context) {
        // No implementation needed
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    private void logFailureDetails(ITestResult result) {
        WebDriver driver = getDriverFromResult(result);
        if (driver != null) {
            try {
                String screenshotPath = getScreenshot(result.getMethod().getMethodName(), driver);
                extentTest.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private WebDriver getDriverFromResult(ITestResult result) {
        try {
            return (WebDriver) result.getTestClass().getRealClass()
                    .getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
