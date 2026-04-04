package day15slider;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sliderdemo {
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");	
		
		driver.manage().window().maximize();
		//min slider
		WebElement min=driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		System.out.println(min.getLocation());	//.getX() give x axis getY() give y axis
		Actions a=new Actions(driver);
		a.dragAndDropBy(min, 100, 250).perform();//slider syntax
		System.out.println(min.getLocation());	//.getX() give x axis getY() give y axis
//max slider
		WebElement max=driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));//613,246
		System.out.println(max.getLocation());	//.getX() give x axis getY() give y axis
		//Actions a=new Actions(driver);
		a.dragAndDropBy(max,-13,246 ).perform();//slider syntax
		System.out.println(max.getLocation());
		
		
	}
	
	
	

}
