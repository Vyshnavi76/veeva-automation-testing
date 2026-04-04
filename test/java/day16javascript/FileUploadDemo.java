package day16javascript;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		// single file upload selenim.docx
	/*	driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\vyshn\\OneDrive\\Desktop\\selenium.docx");
      if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("selenium.docx"))
      {
    	  System.out.println("file is uploaded");
      }
      else
      {
    	  System.out.println("File is not uploaded");
      }
       */
		
		//upload multiple files
		String f1="C:\\Users\\vyshn\\OneDrive\\Desktop\\selenium.docx";
		String f2="C:\\Users\\vyshn\\OneDrive\\Desktop\\05d1_xray.docx";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(f1+"\n"+f2);
		
	int n=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
	if(n==2)
	{
		System.out.println("Files are Uploaded");
		
	}
	else
	{
		System.out.println("Not Uploaed");
	}
	
	}

}
