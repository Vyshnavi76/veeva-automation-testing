package day13datepickers;

import java.time.Duration;
import java.time.Month;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Datemethod3 {
	
	//user defined function for converting month from string--->month
	static Month convertM(String month)
	{
		HashMap<String,Month> hm=new HashMap<>();
		hm.put("Jan",Month.JANUARY );
		hm.put("Feb",Month.FEBRUARY );
		hm.put("Mar",Month.MARCH );
		hm.put("Apr",Month.APRIL);
		hm.put("May",Month.MAY);
		hm.put("Jun",Month.JUNE );
		hm.put("Jul",Month.JULY );
		hm.put("Aug",Month.AUGUST );
		hm.put("Sep",Month.SEPTEMBER );
		hm.put("Oct",Month.OCTOBER );
		hm.put("Nov",Month.NOVEMBER );
		hm.put("Dec",Month.DECEMBER );
		Month v=hm.get(month);
		if(v==null)
		{
			System.out.println("Invalid month...");
		}
		return v;
		
	}
	
	static void selectDate(WebDriver driver,String year,String month,String date)
	
	{
		WebElement y=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select s=new Select(y);
		s.selectByVisibleText(year);
		
		//select month
		while(true)
		{
			WebElement monthElement = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			Select monthSelect = new Select(monthElement);
			String cumon = monthSelect.getFirstSelectedOption().getText();

		//convert reqmonth and currentmonth
		Month expectedmonth=convertM(month);
		Month cur=convertM(cumon);		
		
		//compare months
		int result=expectedmonth.compareTo(cur);
		//0 equals
		//>0 future
		//<0 past
		if(result<0) 
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		else if(result>0)
		{
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();	
		}
		else
		{
			break;
		}
		
		}
		//select date
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


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		//input
		String year="2024";
		String monthh="May";
		String date="21";
		
		driver.findElement(By.id("txtDate")).click();
		
		selectDate(driver,year,monthh,date);
		
	}

}
