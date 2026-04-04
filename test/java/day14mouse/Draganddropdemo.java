package day14mouse;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddropdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");	
		
		driver.manage().window().maximize();
		Actions a=new Actions(driver);
		
		WebElement s=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement t=driver.findElement(By.xpath("//div[@id='droppable']"));
       a.dragAndDrop(s, t).perform();
       
		
	}

}
