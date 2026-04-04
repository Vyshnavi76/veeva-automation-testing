package day18brokenlink;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shadowdomdemo {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		//Element in single shadow dom
		//String css1="book-app[apptitle='Books']";
		//Thread.sleep(3000);
		SearchContext sh=driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(3000);
		sh.findElement(By.cssSelector("#input")).sendKeys("Vyshnavi");
		
		
		
		
		
	}

}
