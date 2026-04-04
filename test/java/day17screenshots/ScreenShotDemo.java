package day17screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//full page screenshot		
		
		/*TakesScreenshot ts=(TakesScreenshot) driver; 
		File ss=ts.getScreenshotAs(OutputType.FILE);//calls from takeshreenshot interface
		//D:\Selenium_WebDriver\seleniumwebdriver\Screenshot
		File tr=new File(System.getProperty("user.dir")+"\\Screenshot\\fullpage.png");
		ss.renameTo(tr);//copy sourcefile
	*/	
		//capture the screenshot for specific eleemnt
	/*	WebElement fe=driver.findElement(By.xpath("//section[@class=\"product-grid home-page-product-grid\"]"));
		File sou=fe.getScreenshotAs(OutputType.FILE); //calls by webelement
		File tr=new File(System.getProperty("user.dir")+"\\Screenshot\\specific.png");
		sou.renameTo(tr);
		*/
		//capture the logo or webelement
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
		
		File sou=logo.getScreenshotAs(OutputType.FILE); //calls by webelement
		File tr=new File(System.getProperty("user.dir")+"\\Screenshot\\logo.png");
		sou.renameTo(tr);
		
		
		
	}

}
