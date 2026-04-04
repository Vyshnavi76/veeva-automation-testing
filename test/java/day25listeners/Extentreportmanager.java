package day25listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreportmanager implements ITestListener 
{
public  static ExtentSparkReporter sparkReporter;  // UI of the report
public static ExtentReports extent;               // Populate common info
public static ExtentTest test;                    // Create test case entries

@BeforeSuite
public void onStart(ITestContext context) {

    // Report location
    sparkReporter = new ExtentSparkReporter(
            System.getProperty("user.dir") + "/reports/myReport.html");

    // Report configuration
    sparkReporter.config().setDocumentTitle("Automation Report");
    sparkReporter.config().setReportName("Functional Testing");
    sparkReporter.config().setTheme(Theme.DARK);

    // Attach reporter to ExtentReports
    extent = new ExtentReports();
    extent.attachReporter(sparkReporter);
    extent.setSystemInfo("Computer Name", "localhost");
    extent.setSystemInfo("Environment", "QA");
    extent.setSystemInfo("Tester Name", "Vyshnavi");
      extent.setSystemInfo("OS", "Windows 10");
    extent.setSystemInfo("Browser", "Chrome");
}
public void onTestSuccess(ITestResult result) {

    test = extent.createTest(result.getName());  // create new entry in report
    test.log(Status.PASS, "Test case PASSED is: " + result.getName());
}
public void onTestFailure(ITestResult result) {

    test = extent.createTest(result.getName());  // create new entry in report
    test.log(Status.FAIL, "Test case FAILED is: " + result.getName());
    test.log(Status.FAIL, "Test case FAILED cause is: " + result.getThrowable());

}
public void onTestSkipped(ITestResult result) {

    test = extent.createTest(result.getName());  // create new entry in report
    test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName());
}
public void onFinish(ITestContext context)
{
	extent.flush();
}

}
