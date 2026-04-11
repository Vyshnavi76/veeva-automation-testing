package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class ProductPage {

    WebDriver driver = BaseTest.driver;

    By products = By.xpath("//picture/img");By addToCart = By.xpath("//span[text()='add to cart']");
    By productTitle = By.cssSelector(".pdp-e-i-head");

    By subtotal = By.xpath("//span[contains(text(),'Rs') or contains(text(),'₹')]");
    By total = By.xpath("//*[contains(text(),'Total') or contains(text(),'Pay') or contains(text(),'Amount')]");
    By cartCount = By.cssSelector(".cartQuantity");
    
    // to handle to select the product in product page
    public boolean selectAnyProductSafe() {

    	// to wait until the page is completely loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState")
                .toString().equals("complete"));

        List<WebElement> list;

        try {
            list = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(products)
            );
        } 
        catch (Exception e) 
        {
            return false;
        }

        System.out.println("Products found: " + list.size());

        if (list.size() == 0) {
            return false; 
        }
        
        list.get(0).click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        
        // to navigate to the products page
        driver.switchTo().window(tabs.get(1));

        return true; 
    }

    // to handle if page is displayed or not
    public boolean isProductPageDisplayed() {
    	
    	System.out.println("Results page is displayed..");
        System.out.println("Selected the first product..");
        return driver.findElement(productTitle).isDisplayed();
    }

    // to add product to cart
    public void clickAddToCart() {
        driver.findElement(addToCart).click();
        System.out.println("Product is added to cart..");
    }

    // to handle subtotal amount
    public boolean isSubtotalDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(subtotal)
            );
            return element.isDisplayed();
        } 
        catch (Exception e) 
        {
            return false;
        }
    }
    
    // to validate the sub total amount
    public String getSubtotalText() {

        try 
        {
            return driver.findElement(subtotal).getText();
        } 
        catch (Exception e) 
        {
            return "Subtotal not found";
        }
    }
    
    // to handle total amount
    public boolean isTotalDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(total)
            );
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    // to validate total amount
    public String getTotalText() {

        try {
            String value = driver.findElement(total).getText();

            if (value == null || value.isEmpty()) {
                return getSubtotalText(); 
            }

            return value;

        } catch (Exception e) {
            return getSubtotalText(); 
        }
    }
    
    // to handle cart status
    public String getCartCount() {

        try {
            String count = driver.findElement(cartCount).getText();

            if (count == null || count.isEmpty()) {
                return "0";
            }

            return count;

        } catch (Exception e) {
            return "0";
        }
    }
}