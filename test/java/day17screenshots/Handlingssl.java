package day17screenshots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Handlingssl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions o=new ChromeOptions();
       o.setAcceptInsecureCerts(true); //accepts ssl certificate
		
		
		
		WebDriver driver=new ChromeDriver(o);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());//privacy error

	}

}
