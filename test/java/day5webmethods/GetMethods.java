package day5webmethods;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		
		//gettitle()
       System.out.println(driver.getTitle());
       
       //getcurrenturl
       System.out.println(driver.getCurrentUrl());
       
       //getpagesource
       //System.out.println(driver.getPageSource());
       
       //getwindowhandle
       //System.out.println(driver.getWindowHandle());
      //driver.findElement(By.linkText("Start here")).click();
       
       Set<String> win=driver.getWindowHandles();       
       System.out.println(win);
       
       
	}

}
