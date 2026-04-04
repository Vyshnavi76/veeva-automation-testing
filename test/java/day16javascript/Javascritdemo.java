package day16javascript;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Javascritdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
//passing the test into input box-alternate of sendkeys
		JavascriptExecutor js=(JavascriptExecutor)driver;//upcasting
		
		js.executeScript("arguments[0].setAttribute('value','Vyshu')",name);
		//click method alternate
		WebElement radio=driver.findElement(By.xpath("//input[@id='female']"));
		js.executeScript("arguments[0].click()",radio);
		
	}

}
