package GrandTest;

import java.io.*;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Question1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testdata.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(fs);
		
		XSSFSheet sh=w.getSheet("Sheet1");
		 int r = sh.getLastRowNum();
	        int c = sh.getRow(0).getLastCellNum();

	        System.out.println("Rows are: " + r + " Columns are: " + c);
	        for (int i = 1; i <= r; i++) {   // skip header row

	            XSSFRow row = sh.getRow(i);

	            String username = row.getCell(0).toString();
	            String password = row.getCell(1).toString();     
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        // Check Dashboard presence (SUCCESS case)
        List<WebElement> dashboard = driver.findElements(
                By.xpath("//h6[text()='Dashboard']"));

        if (dashboard.size() > 0) {
            System.out.println("Username: " + username + " → LOGIN SUCCESS ✅");
        } else {
            System.out.println("Username: " + username + " → LOGIN FAILED ❌");
        }

         driver.quit();
	        }
	        w.close();
	        fs.close();
		

	}

}
