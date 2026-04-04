package day17screenshots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Firsttestcase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions o=new ChromeOptions();
		o.addArguments("--headless=new"); //setting for headless testing
		
		WebDriver driver=new ChromeDriver(o);
		driver.get("https://tutorialsninja.com/demo/");
		String t=driver.getTitle();
		if(t.equals("Your Store"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Not passed");
		}

	}

}
