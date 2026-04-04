package day4xpath;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		//xpath with single attribute
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Books");
		
		//xpath wi th multiple attributes
		//driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("comic Books");
		
		//xpath and attribute
		//driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("comic Books");
		
		//xpath or attribute
		//driver.findElement(By.xpath("//input[@name='search' or @placeholder='Seah']")).sendKeys("comic Books");
		
		//xpath with inner text -text()
		driver.findElement(By.xpath("//*[text()='MacBook']")).click();
		
		//xpath with contains
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("Books");
		
		//xpath with starts-with()
		//driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("Pens");
		
		//xpath with chained xpath
		boolean im=driver.findElement(By.xpath("//div[@id='logo']")).isDisplayed();
		System.out.println(im);
		
		
		
		
		

	}

}
