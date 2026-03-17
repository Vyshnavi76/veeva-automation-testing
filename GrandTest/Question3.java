package GrandTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Question3 {
	  WebDriver driver;
	    String[][] data;

	    // ✅ Read Excel
	    @BeforeClass
	    public void setup() throws IOException {

	        FileInputStream fs = new FileInputStream(
	                System.getProperty("user.dir") + "\\testdata\\testdata.xlsx");

	        XSSFWorkbook w = new XSSFWorkbook(fs);
	        XSSFSheet sh = w.getSheet("Sheet1");

	        int r = sh.getLastRowNum();
	        int c = sh.getRow(0).getLastCellNum();

	        data = new String[r][c];

	        for (int i = 1; i <= r; i++) {
	            XSSFRow row = sh.getRow(i);
	            for (int j = 0; j < c; j++) {
	                data[i - 1][j] = row.getCell(j).toString();
	            }
	        }
	        w.close();
	        fs.close();

	        // Launch browser ONCE
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    // ✅ DataProvider
	    @DataProvider(name = "loginData")
	    public Object[][] getData() {
	        return data;
	    }
	    @Test(dataProvider = "loginData")
	    public void loginTest(String username, String password) throws InterruptedException {

	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        driver.findElement(By.name("username")).sendKeys(username);
	        driver.findElement(By.name("password")).sendKeys(password);
	        driver.findElement(By.xpath("//button[@type='submit']")).click();

	        Thread.sleep(2000);

	        if (driver.findElements(By.xpath("//h6[text()='Dashboard']")).size() > 0) {
	            System.out.println("Username: " + username + " → LOGIN SUCCESS ✅");
	        } else {
	            System.out.println("Username: " + username + " → LOGIN FAILED ❌");
	        }
	    }
	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

}
