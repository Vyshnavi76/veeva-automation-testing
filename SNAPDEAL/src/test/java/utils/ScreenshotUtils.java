package utils;

import org.openqa.selenium.*;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtils {

	// to capture screenshots on failures with given names
    public static void capture(WebDriver driver, String name) {

        try {
        	
        	// to capture screenshot using WebDriver
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            // to save screenshot to local folder
            FileUtils.copyFile(src, new File("screenshots/" + name + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}