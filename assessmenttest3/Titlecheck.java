package assessmenttest3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Titlecheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		String t=driver.getTitle();
		if(t.equals("Google"))
		{
			System.out.println("Title matched");
		}
		else
		{
			System.out.println("Title not matched");
		}
		
		String sc=driver.getCurrentUrl();
		System.out.println("Current url is "+sc);
		if(sc.contains("google.co"))
		{
			System.out.println("Redirected");
		}
		else
		{
			System.out.println("Not redirecdte");
		}

	}

}
