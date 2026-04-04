package day15slider;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoarddemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		//locate tje input box 1
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome to selenium couse akfhjgbkfhjdhdykfh djshkfjhikdj");
		
		Actions a=new Actions(driver);

		//ctrl+a-select text
		a.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//ctrl+c-copy
		a.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

			
		//tab-shift to next box
		a.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//ctrl+v-oaste
		a.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

		

		
		
		
		
		
		
	}

}
