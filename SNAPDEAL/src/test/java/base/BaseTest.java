package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {

    public static WebDriver driver;

    //setup() 
    public static void initDriver() {
    	
        String browser = ConfigReader.get("browser");
        
        // if browser is not initialized then the default browser is chrome
        if(browser==null)
        {
        	browser="chrome";
        }

        if (browser.equalsIgnoreCase("chrome")) {

        	// to disable automation detection
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            System.out.println("Chrome browser is launched..");
        } 
        else 
        {
            System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
            System.out.println("Edge browser is launched..");
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
        System.out.println("Snapdeal is opening..");
    }

    //tearDown()
    public static void quitDriver() {
        driver.quit();
        System.out.println("Browser is Closing..");
    }
}