package day18brokenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlinkdemo {

	public static void main(String[] args) throws IOException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		List<WebElement> link=driver.findElements(By.tagName("a"));
		System.out.println(link.size());
		int b=0;
		for(WebElement w:link)
		{
			String h=w.getAttribute("href");
			if(h==null||h.isEmpty())
			{
				System.out.println("href attribute is null not possible to check");
				continue;
			}
			//hit url to server
			try
			{
			URL linkurl=new URL(h); //convert href value from string to url
			HttpURLConnection con=(HttpURLConnection) linkurl.openConnection(); //opens the connection to the server
			con.connect(); //connect to server and send request to the server
			if(con.getResponseCode()>=400)
			{
				System.out.println("Broken link ");
				b++;
			}
			else
			{
				System.out.println("Not a broken link");
			}
			}
			catch(Exception e)
			{
				
			}
			
		}
		System.out.println("No of broken links "+b);

	}

}
