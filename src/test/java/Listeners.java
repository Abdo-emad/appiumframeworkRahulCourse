import Utils.GetExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    ExtentReports test = GetExtentReport.ConfigExtentReport();
    ExtentTest extentTest;
    @Override
    public void onTestStart(ITestResult result) {
       extentTest= test.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,"Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL,"Test Failed");
        extentTest.fail(result.getThrowable());

    }
@Override
    public void onTestSkipped(ITestResult result) {
    }
    @Override
    public void onFinish(ITestContext context) {
        test.flush();
    }

}
