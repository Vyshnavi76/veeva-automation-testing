package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DataReader;
import utils.ExcelUtils;
import utils.ExtentManager;

public class Hooks {

	// to initialize the extent reports instance for reporting
    ExtentReports extent = ExtentManager.getInstance();

    @Before
    public void setup(Scenario scenario) {

        BaseTest.initDriver();
        
        // to create test entry in the reports
        ExtentManager.test = extent.createTest(scenario.getName());

        // data driven execution
        if (DataReader.menuData == null) {
        	DataReader.menuData =
                ExcelUtils.getData(
                    System.getProperty("user.dir") +
                    "/src/test/resources/testdata/menuData.xlsx"
                );
        }
    }

    @After
    public void tearDown(Scenario scenario) {

        if (BaseTest.driver != null) 
        {
            BaseTest.quitDriver();
        }

        // to move for next data
        if (DataReader.index < DataReader.menuData.size() - 1) 
        {
            DataReader.index++;
        } 
        
        // to reset index after last row
        else 
        {
            DataReader.index = 0;
        }
    }
}