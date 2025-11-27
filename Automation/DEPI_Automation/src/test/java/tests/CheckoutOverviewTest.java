package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutOverviewPage;

@Test(groups = "loginRequired")
public class CheckoutOverviewTest extends BaseTest {

    private CheckoutOverviewPage overviewPage;

    @BeforeMethod
    public void setupOverviewTest() {
        productsPage.addFirstProductToCart();
        cartPage = productsPage.goToCart();


        checkoutInfoPage = cartPage.clickCheckout();
        checkoutInfoPage.fillInfoAndContinue("Aml", "Ahmed", "12345");


        overviewPage = new CheckoutOverviewPage(driver);
    }

    @Test(priority = 1, description = "Verify item details in overview page")
    public void testProductDetailsInOverview() {

        String actualName = overviewPage.getDisplayedProductName();
        Assert.assertEquals(actualName, "Sauce Labs Backpack", "Wrong product name in overview!");


        String actualPrice = overviewPage.getDisplayedProductPrice();
        Assert.assertTrue(actualPrice.contains("$29.99"), "Product price is incorrect!");
    }

    @Test(priority = 2, description = "Verify total price calculation")
    public void testTotalPriceLabel() {

        String totalLabel = overviewPage.getTotalLabel();
        System.out.println("Total displayed: " + totalLabel);

        Assert.assertTrue(totalLabel.contains("Total: $"), "Total label format is wrong!");
    }

    @Test(priority = 3, description = "Verify finishing the order")
    public void testFinishOrder() {
        overviewPage.clickFinish();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-complete.html"), "Did not redirect to complete page!");

    }
}