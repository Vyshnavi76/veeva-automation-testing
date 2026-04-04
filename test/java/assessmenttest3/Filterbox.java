package assessmenttest3;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filterbox {
	
	public static void main(String args[]) throws InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("book");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> li = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"));
		boolean op=false;
		for(WebElement wb:li)
		{
			if(wb.getText().equalsIgnoreCase("Book of Enoch"))
			{
				wb.click();
				op=true;
				break;
			}
		}
		if(op)
		{
			System.out.println("not selected");
		}
		else
		{
			System.out.println("selected");
		}
	
	}

}
