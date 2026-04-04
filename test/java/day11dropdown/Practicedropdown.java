package day11dropdown;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Practicedropdown {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bjs.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='What are you looking for today?']")).sendKeys("bird");
		Thread.sleep(5000);
		List<WebElement> l=driver.findElements(By.xpath("//div[@class='list list-group']"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
			if(l.get(i).getText().equals("bird eye"))
			{
				l.get(i).click();
				break;
			}
		}
}

}
