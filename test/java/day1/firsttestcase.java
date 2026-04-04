package day1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
public class firsttestcase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//open chrone
		WebDriver driver=new ChromeDriver();
		//open url
		driver.get("https://tutorialsninja.com/demo/");
		//driver.manage().window().maximize();
		
		// validate title
		String act_title=driver.getTitle();
		if(act_title.equals("Your Store"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		//close
		//driver.close();
		

	}

}
