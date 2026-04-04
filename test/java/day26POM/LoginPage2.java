package day26POM;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage2 {
	

	
	
	WebDriver driver;
		
		//page factory contains 3 elements
		
		//constructor
		LoginPage2(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		//locators
		/*By user=By.xpath("//input[@placeholder='Username']");
		By pas=By.xpath("//input[@placeholder='Password']");
		By btn=By.xpath("//button[@type='submit']");
		*/
		@FindBy(xpath="//input[@placeholder='Username']") WebElement user;
		@FindBy(xpath="//input[@placeholder='Password']") WebElement pas;
		@FindBy(xpath="//button[@type='submit']") WebElement btn;
		
		@FindBy(tagName="a")
		List<WebElement> links;
		
		
		
		
		
		
		//Action methods
		public void setUserName(String us)
		{
			user.sendKeys(us);
		}
		
		public void setPassword(String pa)
		{
			pas.sendKeys(pa);
		}
		
		public void clicklogin()
		{
			btn.click();
		}
		

	}

