package day11dropdown;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bootstrapdropdown {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();//opens dropdownoptions
		
		//select single option
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//capture all options and its size
		List<WebElement> op=driver.findElements(By.xpath("//u[contains(@class,'multiselect')]//label"));
		System.out.println(op.size());
		//printing options
		for(int i=0;i<op.size();i++)
		{
			System.out.println(op.get(i).getText());
		}
		
		//select multiple options
		for(int i=0;i<op.size();i++)
		{
			String o=op.get(i).getText();
			if(o.equals("Java") || o.equals("Python"))
			{
			((WebElement) op).click();	
			}
		}
		
		
		

	}

}
