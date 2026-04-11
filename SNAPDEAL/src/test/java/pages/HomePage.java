package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class HomePage {

    WebDriver driver = BaseTest.driver;

    By searchBox = By.id("search-box-input");
    
    // to search products on the home page in search box
    public void searchProduct(String product) {

    	// to wait until the page is completely loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        WebElement search = wait.until(
            ExpectedConditions.visibilityOfElementLocated(searchBox)
        );
        
        System.out.println("Searching for "+product+" ..");
        
        search.clear();
        
        search.sendKeys(product + Keys.ENTER);
    }

    // to navigate on the required section for scenario 2
    public void hoverOnSectionAndSelectionLabel(String section, String item) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        // actions class for mouse hovering
        Actions actions = new Actions(driver);

        // find top categories
        List<WebElement> categories = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("div[class*='TabsCategoriesStyle__TabsCategoriesItemText']")
            )
        );

        WebElement mainCategory = null;

        // to locate the required section in the menu bar over all sections
        for (WebElement sample : categories) {
            if (sample.getText().trim().equalsIgnoreCase(section)) {
                mainCategory = sample;
                break;
            }
        }

        // to handle negative case where section is not available
        if (mainCategory == null) {
            throw new RuntimeException("Section not found: " + section);
        }

        // to hover on required section
        actions.moveToElement(mainCategory).pause(2000).perform();
        System.out.println("Hovered on: " + section);

        // to get all dropdown elements in the section
        List<WebElement> subItems = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class,'TabsCategories')]//div")
            )
        );

        boolean found = false;

        // to select the required item
        for (WebElement sample : subItems) {

            String text = sample.getText().trim();

            if (text.length() == 0) continue;

            if (text.equalsIgnoreCase(item)) {

                try 
                {
                    sample.click();
                } 
                
                // used jsexecutor if the element is not clickable
                catch (Exception e) 
                {
                    ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", sample);
                }

                System.out.println("Clicked on: " + text);
                found = true;
                break;
            }
        }

        // to handle negative case where item is not available
        if (!found) {
            throw new RuntimeException("Sub-item not found: " + item);
        }
    }
    
}