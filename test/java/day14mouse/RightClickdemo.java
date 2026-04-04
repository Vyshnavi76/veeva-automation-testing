package day14mouse;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");	
		
		driver.manage().window().maximize();
		WebElement r=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		//right click
		Actions a=new Actions(driver);
		a.contextClick(r).perform();
		//click on copy
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		
		//close alert window
		
		driver.switchTo().alert().accept();
		
		
		
		

	}

}
