package day26POM;
import org.openqa.selenium.*;
public class Loginpage {
	
	WebDriver driver;
	//page factory contains 3 elements
	
	//constructor
	Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	//locators
	By user=By.xpath("//input[@placeholder='Username']");
	By pas=By.xpath("//input[@placeholder='Password']");
	By btn=By.xpath("//button[@type='submit']");
	
	
	//Action methods
	public void setUserName(String us)
	{
		driver.findElement(user).sendKeys(us);
	}
	
	public void setPassword(String pa)
	{
		driver.findElement(pas).sendKeys(pa);
	}
	
	public void clicklogin()
	{
		driver.findElement(btn).click();
	}

}
