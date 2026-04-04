package assessmenttest3;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browserinstance {
	
	public static void main(String args[])
	{
		WebDriver driver;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter stringe");
		String s=sc.next();
		if(s.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(s.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(s.equalsIgnoreCase("safari"))
       {
	       driver=new SafariDriver();
        }
		else if(s.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid driver");
			return;
		}
		sc.close();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

}
