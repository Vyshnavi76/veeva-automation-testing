package day25listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
@Listeners(day25listeners.Mylistener.class)
public class Orangehrmtest {
	WebDriver driver;
	void setup() throws InterruptedException 
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	
	@Test(priority=2)
	void testAppurl()
	{
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority=3,dependsOnMethods= {"testAppurl"})
	void testhomepagetitle()
	{
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	}
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	

}
