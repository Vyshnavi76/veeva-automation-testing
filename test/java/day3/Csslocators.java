package day3;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Csslocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//tagid here tag is optional
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirts");
	 
		//tag and class
	//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("books");
	
		//tag attribute
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Paper");
	
		//tag class attribute
		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("book");
	
	
	
	}
	

}
