package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;
    
    // to hold current data instance for logging
    public static ExtentTest test;

    // to return the extent reports
    public static ExtentReports getInstance() {

        if (extent == null) {

        	// to configure report file location
            ExtentSparkReporter reporter =
                new ExtentSparkReporter("target/ExtentReport.html");

            // to create extent reports
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }
}