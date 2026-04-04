package day20ddttesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		//path of file
		String filepath=System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		int rows=Excelutils.getRowCount(filepath,"Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			//read data from excel
			
			String p=Excelutils.getCellData(filepath, "Sheet1", i, 0);
			String r=Excelutils.getCellData(filepath, "Sheet1", i, 1);
			String per1=Excelutils.getCellData(filepath, "Sheet1", i, 2);
			String per2=Excelutils.getCellData(filepath, "Sheet1", i, 3);
			String fre=Excelutils.getCellData(filepath, "Sheet1", i, 4);
			String ex=Excelutils.getCellData(filepath, "Sheet1", i, 5);

						//pass above data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(p);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(r);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			Select pe=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			pe.selectByVisibleText(per2);
			
		Select fe=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fe.selectByVisibleText(fre);
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			
			//validation
			
			String val=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			if(Math.abs(Double.parseDouble(ex) - Double.parseDouble(val)) < 0.01)
			{
				System.out.println("Test passed");
				Excelutils.setCellData(filepath,"Sheet1",i,7,"Passed");
				Excelutils.fillGreenColor(filepath, "Sheet1", i, 7);
				
			}
			else
			{
				System.out.println("Test failed");
				Excelutils.setCellData(filepath,"Sheet1",i,7,"Failed");
				Excelutils.fillRedColor(filepath, "Sheet1", i, 7);
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click(); //clear
			
		}
		
		driver.quit();
		
		

	}

}
