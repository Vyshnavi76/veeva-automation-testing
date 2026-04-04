package day5webmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//isdisplayed
		//WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        //System.out.println(logo.isDisplayed());
		//boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		//System.out.println(status);
		
		//isenabled
		//boolean st=driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		//System.out.println(st);
		
		//isSelected
		boolean st=driver.findElement(By.xpath("//input[@id='gender-female']")).isSelected();
		System.out.println(st);
		
		
		
		
		
		
		
		
	}

}
