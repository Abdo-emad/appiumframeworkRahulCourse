package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GetExtentReport {
    static ExtentReports extent;
    public static ExtentReports ConfigExtentReport(){
        String path = System.getProperty("user.dir")+"src/main/resources/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("ExtentReportForAppium");
        reporter.config().setDocumentTitle("Appium Report");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Rahull");
        return extent;

    }
}
