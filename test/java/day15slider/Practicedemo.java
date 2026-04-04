package day15slider;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practicedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement r=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		Actions a=new Actions(driver);
		//cntrl+link
		a.keyDown(Keys.CONTROL).release().click(r).keyUp(Keys.CONTROL).perform();
		//switching to reg page
		
		List<String> id=new ArrayList<String>(driver.getWindowHandles()); //set is converted into arraylist
		driver.switchTo().window(id.get(1));//switch to reg page

	}
 
}
