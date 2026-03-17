package GrandTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		//frame1
		WebElement f1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(f1);//passed frame as webelement
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");
		
		driver.switchTo().defaultContent(); //got to mainpage
		
		//frame2
		
		WebElement f2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(f2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Welcome to second frame");
		driver.switchTo().defaultContent(); //got to mainpage

		//frame3
		WebElement f3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(f3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Welcome to third frame");
		
		//inner frame part of frame3
		driver.switchTo().frame(0); //switching to frame index
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		
		driver.switchTo().defaultContent();
		
		
	}


}
