package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = "loginRequired")
public class CheckoutCompleteTest extends BaseTest {


    @BeforeMethod
    public void setupCompletePageTest() {
        productsPage.addFirstProductToCart();
        cartPage = productsPage.goToCart();

        checkoutInfoPage = cartPage.clickCheckout();
        checkoutInfoPage.fillInfoAndContinue("Aml", "Ahmed", "12345");
        checkoutCompletePage= checkoutOverviewPage.clickFinish();

    }

    @Test(priority = 1, description = "Verify order completion messages")
    public void testOrderCompletionMessages() {
        String header = checkoutCompletePage.getSuccessHeaderText();
        Assert.assertEquals(header, "Thank you for your order!", "Wrong success header!");

        String msg = checkoutCompletePage.getSuccessMessageText();
        Assert.assertTrue(msg.contains("dispatched"), "Success message content mismatch!");
    }

    @Test(priority = 2, description = "Verify Pony Express image presence")
    public void testCompletionImage() {
        Assert.assertTrue(checkoutCompletePage.isPonyExpressImageDisplayed(), "Success image is missing!");
    }

    @Test(priority = 3, description = "Verify 'Back Home' navigation")
    public void testBackToHome() {

        productsPage = checkoutCompletePage.clickBackHome();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Back Home button didn't redirect to products page!");
    }
}