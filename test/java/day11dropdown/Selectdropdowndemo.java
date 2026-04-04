package day11dropdown;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Selectdropdowndemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement d=driver.findElement(By.xpath("//select[@id='country']"));
		Select de=new Select(d);
		//select option from dropdown
		
		//de.selectByVisibleText("India"); //can be used in anytime
		//de.selectByValue("canada"); //want to consider the value
		//de.selectByIndex(8); //manually want to select
          
		//counting total no of options
		List<WebElement> l=de.getOptions();
		System.out.println(l.size());
		
		//printing the options
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		
		
		
		
		
		
	}

}
