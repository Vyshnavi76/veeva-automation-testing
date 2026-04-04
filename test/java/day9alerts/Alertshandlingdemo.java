package day9alerts;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Alertshandlingdemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//normal ok button
		/*driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(5000);
		Alert my=driver.switchTo().alert();
		System.out.println(my.getText());
		my.accept();
		*/
		
		//conformation alert
		/*driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(3000);
		Alert my=driver.switchTo().alert();
		System.out.println(my.getText());
		//my.accept();
		my.dismiss();
		*/
		
		//prompt alert
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Thread.sleep(3000);
		Alert my=driver.switchTo().alert();
		System.out.println(my.getText());
		my.sendKeys("Vyshnavi");
		//my.accept();
		my.dismiss();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
