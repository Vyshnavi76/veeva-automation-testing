package day25listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Mylistener implements ITestListener 
{
	public void onStart(ITestResult context)
	{
		System.out.println("Test execution is started..");
	}
	public void onTestStart(ITestResult result) {
	    // not implemented
		System.out.println("Test execution is spassed.");

	  }
	public  void onTestSuccess(ITestResult result) {
	    // not implemented
		System.out.println("Test execution is success..");

	  }
	 public  void onTestFailure(ITestResult result) {
		    // not implemented
			System.out.println("Test execution is failed..");

		  }

	 public void onTestSkipped(ITestResult result) {
		    // not implemented
			System.out.println("Test execution is skipped..");

		  }
	 public  void onFinish(ITestContext context) {
		    // not implemented
			System.out.println("Test execution is completed...");

		  }
	
	
	
	
	
}
