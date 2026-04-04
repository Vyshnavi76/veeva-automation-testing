package day11dropdown;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Automatedropdoen {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(5000);
		
		List<WebElement> l=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++) {
			System.out.println(l.get(i).getText());
			if(l.get(i).getText().equals("selenium"))
			{
				l.get(i).click();
				break;
			}
		}
		
		
		
		
		

	}

}
