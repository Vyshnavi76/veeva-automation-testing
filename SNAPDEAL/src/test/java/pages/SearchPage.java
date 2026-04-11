package pages;

import org.openqa.selenium.*;
import base.BaseTest;
import java.util.List;

public class SearchPage {

    WebDriver driver = BaseTest.driver;
    By products = By.xpath("//picture/img");

    // to validate results page
    public boolean validateResults() {
        List<WebElement> list = driver.findElements(products);
        System.out.println("Results page is displayed..");
        return list.size() > 0;
    }
}