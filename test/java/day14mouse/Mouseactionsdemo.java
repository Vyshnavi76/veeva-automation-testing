package day14mouse;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Mouseactionsdemo {

	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");	
		
		driver.manage().window().maximize();
		WebElement desk=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		//mouse hover
		Actions a=new Actions(driver);
		a.moveToElement(desk).moveToElement(mac).click().build().perform();
		
		
		
		
		
	}
}
