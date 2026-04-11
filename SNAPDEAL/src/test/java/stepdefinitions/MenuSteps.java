package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductPage;
import utils.ExcelUtils;

// to handle scenario2
public class MenuSteps {

    HomePage home = new HomePage();
    ProductPage product = new ProductPage();
    double grandTotal = 0;
    int expectedCartCount = 0;

    // to extract numeric value from text
    private double extractAmount(String text) {
        try 
        {
            return Double.parseDouble(text.replaceAll("[^0-9]", ""));
        } 
        catch (Exception e) 
        {
            return 0;
        }
    }

    @Given("User is on Snapdeal homepage")
    public void openHome() {}

    @When("User performs menu operations from excel")
    public void menuFromExcel() throws InterruptedException {

    	// to perform data driven testing 
        List<Map<String, String>> data =
            ExcelUtils.getData(
                System.getProperty("user.dir") +
                "/src/test/resources/testdata/menuData.xlsx"
            );

        for (Map<String, String> row : data) {

            String section = row.get("section");
            String item = row.get("item");

            System.out.println("Running for:: " + section + " : " + item);

            try 
            {
            	// to hover and click
                home.hoverOnSectionAndSelectionLabel(section, item);
            } 
            catch (Exception e) 
            {
            	// to handle negative cases
                System.out.println("Navigation failed for: " + section + " -> " + item + " (handled)");
                System.out.println();
                continue; 
            }

            boolean productSelected = product.selectAnyProductSafe();

            if (!productSelected) {
                System.out.println("No products found for this category - handled correctly\n");
                continue;
            }

            // to validate the opening of product page
            Assert.assertTrue(product.isProductPageDisplayed(),
                "Product page not displayed");

            product.clickAddToCart();

            // to fetch and process amounts
            String subtotalText = product.getSubtotalText();
            double subtotalValue = extractAmount(subtotalText);

            grandTotal += subtotalValue;
            expectedCartCount++;

            String cartCount = product.getCartCount();

            System.out.println("Subtotal: " + subtotalText);
            System.out.println("Estimated Total: Rs. " + grandTotal);
            System.out.println("Cart Count: " + cartCount);

            // to validate sub total
            Assert.assertTrue(product.isSubtotalDisplayed(), "Subtotal not displayed");

            // to validate the cart count 
            Assert.assertEquals(
                Integer.parseInt(cartCount),
                expectedCartCount,
                "Cart count mismatch"
            );

            System.out.println("Validations passed for: " + item);
            System.out.println();

            Thread.sleep(2000);

            BaseTest.driver.close();

            for (String handle : BaseTest.driver.getWindowHandles()) {
                BaseTest.driver.switchTo().window(handle);
                break;
            }

            // to switch back to main page
            BaseTest.driver.navigate().to("https://www.snapdeal.com/");
            Thread.sleep(3000);
        }
    }
}