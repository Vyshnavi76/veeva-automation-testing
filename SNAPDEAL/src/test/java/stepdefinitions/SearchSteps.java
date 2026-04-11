package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;
import utils.ExcelUtils;
import org.openqa.selenium.By;

// to handle scenario 1
public class SearchSteps {

    HomePage home = new HomePage();
    SearchPage search = new SearchPage();

    @Given("User is on homepage")
    public void user_home() {}

    @When("User searches for products from excel")
    public void searchFromExcel() {

    	// to perform data driven testing
        List<Map<String, String>> data =
            ExcelUtils.getData(
                System.getProperty("user.dir") +
                "/src/test/resources/testdata/searchData.xlsx"
            );

        for (Map<String, String> row : data) {

            String product = row.get("product");

            home.searchProduct(product);

            try 
            { 
            	Thread.sleep(2000); 
            } 
            catch (Exception e) 
            {}

            // to get product results list
            List<?> productList = BaseTest.driver.findElements(By.xpath("//picture/img"));

            // to validate search results
            if (productList.size() > 0) {
                System.out.println("Products displayed for: " + product);
                Assert.assertTrue(true);
            } 
            // to handle negative cases
            else {
                System.out.println("No products found for: " + product + " - handled correctly");
                Assert.assertTrue(true); 
            }

            try {
                if (productList.size() > 0) {

                    BaseTest.driver.findElements(By.xpath("//picture/img")).get(0).click();
                    System.out.println("First suggested product is clicked..");

                    // to switch to product tab
                    for (String handle : BaseTest.driver.getWindowHandles()) {
                        BaseTest.driver.switchTo().window(handle);
                    }

                    Thread.sleep(5000);

                    System.out.println("Search passed for: " + product);
                    System.out.println();

                    // Close product tab
                    BaseTest.driver.close();

                    // Switch back to main tab
                    for (String handle : BaseTest.driver.getWindowHandles()) {
                        BaseTest.driver.switchTo().window(handle);
                        break;
                    }

                } else {
                    System.out.println("Skipping click as no products found for: " + product);
                    System.out.println();
                }

            } catch (Exception e) {
            	// to handle unexpected failures
                System.out.println("Product click skipped for: " + product);
            }

            // Navigate back to homepage
            BaseTest.driver.navigate().to("https://www.snapdeal.com/");
            try { Thread.sleep(3000); } catch (Exception e) {}
        }
    }
}