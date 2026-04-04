package day14mouse;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Doubleclickdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");	
		
		driver.manage().window().maximize();
		//first switch to the frame
		driver.switchTo().frame("iframeResult");
		WebElement b1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement b2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement b3=driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        //clear the text b1
		b1.clear();
		b1.sendKeys("Vyshnavi");
		//double click on b3
		Actions a=new Actions(driver);
		a.doubleClick(b3).perform();
		//validation :b2 contains same text as b1
		
		String t=b2.getAttribute("value");
		System.out.println(t);
		if(t.equals("Vyshnavi"))
		{
			System.out.println("text copied...");
			
		}
		else
		{
			System.out.println("Not copied...");
			
		}
	
		
		
		
		
		
		
		
	}

}
