package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataProviders;

@Test(groups ={"loginRequired"})
public class CheckoutInfoTest extends BaseTest {

    @Test(priority = 1, dataProvider = "validCheckoutInfo", dataProviderClass = DataProviders.class)
    public void testSuccessfulCheckoutInfo(String fName, String lName, String pCode) {

        productsPage.addFirstProductToCart();
        productsPage.goToCart();
        cartPage.clickCheckout();


        checkoutInfoPage.fillInfoAndContinue(fName, lName, pCode);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test(priority = 2, dataProvider = "invalidCheckoutInfo", dataProviderClass = DataProviders.class)
    public void testCheckoutInfoValidationMessages(String fName, String lName, String pCode, String expectedError) {

        productsPage.addFirstProductToCart();
        productsPage.goToCart();
        cartPage.clickCheckout();


        checkoutInfoPage.fillInfoAndContinue(fName, lName, pCode);


        String actualError = checkoutInfoPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError);
    }
}