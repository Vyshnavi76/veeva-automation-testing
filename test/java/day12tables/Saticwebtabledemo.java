package day12tables;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Saticwebtabledemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        //find no of rows in table
       int r=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); //multiple tables
        
     // int r=driver.findElements(By.tagName("tr")).size(); //single table
        
       System.out.println(r);
       
       //find no of columns
       int c=driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
       System.out.println(c);
       
       //read data from specific row and column ex 5th row and 1st column
  /*    String s= driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
       System.out.println(s);
       */
       
       //read all data from the table
      /* for(int i=2;i<=r;i++)
       {
    	   for(int j=1;j<=c;j++)
    	   {
    		   String s= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
    	       System.out.println(s+" ");
    	   }
    	   System.out.println();
       }
       */
       
       //print book names whose author is mukesh
      /* for(int i=2;i<=r;i++)
       {
    	   String a= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
    	   if(a.equals("Mukesh"))
    	   {
    		   String b= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
    		   System.out.println(b);
    	   }
       }
       */
       //find total prices of all books
       int t=0;
       for(int i=2;i<=r;i++)
       {
    	   String p= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
    	   t=t+Integer.parseInt(p);
    	   
       }
       System.out.println(t);
       
       
       
        
	}

}
