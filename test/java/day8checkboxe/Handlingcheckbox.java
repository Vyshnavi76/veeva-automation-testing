package day8checkboxe;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Handlingcheckbox {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//select specific checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//select multiplecheckboxes
		List<WebElement> che=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		/*for(int i=0;i<che.size();i++)
		{
			che.get(i).click();
		}*/
		
		//unselect ckech boxes if they are seleceted
		for(int i=0;i<3;i++)
		{
			che.get(i).click();
		}
		Thread.sleep(5000);
		for(int i=0;i<che.size();i++)
		{
			if(che.get(i).isSelected())
			{
			che.get(i).click();
		}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
