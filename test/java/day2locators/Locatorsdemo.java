		package day2locators;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locatorsdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        //name
       // driver.findElement(By.name("search")).sendKeys("Mac");
        
        //id
       //boolean logoDisplay=driver.findElement(By.id("common-home")).isDisplayed();
        //System.out.println(logoDisplay);
        
        //linkedtext And PartialLinktext
       // driver.findElement(By.linkText("iPhone")).click();
        //driver.findElement(By.partialLinkText("Phone")).click();
       
        
        //classname
        
       // List<WebElement> headerlink=driver.findElements(By.className("dropdown"));
        
        //System.out.println("total no of header link:"+headerlink.size());
        
        //tagname
        
       // List<WebElement> link=driver.findElements(By.tagName("a"));
        //System.out.println("total no of link:"+link.size());
        
        //images
        List<WebElement> imga=driver.findElements(By.tagName("img"));
        System.out.println("total no of images:"+imga.size());
        
        
	}

}
