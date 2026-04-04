package day16javascript;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrollingdemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");

		JavascriptExecutor js=(JavascriptExecutor) driver;

	/*	driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		//scroll down page by pixel number
				JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,3000)"," ");
		System.out.println(js.executeScript("return window,pageYOffset;"));
		*/
		
		//scroll the page till element is visible
	/*	driver.get("https://demo.nopcommerce.com/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement ele=driver.findElement(By.xpath("//h2[normalize-space()='Community poll']"));
		js.executeScript("arguments[0].scrollIntoView()",ele);
		System.out.println(js.executeScript("return window,pageYOffset;")); //2288
		*/
		
		//scroll till bottom of page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window,pageYOffset;"));
		
		Thread.sleep(5000);
		//scrolling up to initila position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

		
		
		
	}

}
