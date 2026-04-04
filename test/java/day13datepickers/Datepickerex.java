package day13datepickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepickerex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		//switch to frame
		driver.switchTo().frame(0);
		
		//method1 using sendkeys
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("21/05/2004");
		
		//method 2 using date picker
		
		String year="2004";
		String month="May";
		String date="21";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); //opens date picker
		while(true)
		{
			String m=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String y=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			//String d=driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-hover']")).getText();
			if(m.equals(month) && y.equals(year))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //next
			}
		//select the date
		List<WebElement> l=driver.findElements(By.xpath("//table//tbody//tr//td//a"));
		 for(WebElement dt:l)
		 {
			if( dt.getText().equals(date))
			 {
				 dt.click();
				 break;
			 }
		 }

	}

}
