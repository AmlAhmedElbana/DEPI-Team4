package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"loginRequired"})
public class CartTest extends BaseTest {

    @Test(priority = 1)
    public void testContinueShoppingButton() {
        productsPage.goToCart();

        productsPage = cartPage.clickContinueShopping();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 2)
    public void testRemoveItemFromCart() {
        productsPage.addFirstProductToCart();

        productsPage.goToCart();

        cartPage.removeFirstItem();
        Assert.assertEquals(productsPage.getCartBadgeCount(), "0");
    }
    //Negative Test case
    @Test(priority = 3)
    public void testCheckoutWithEmptyCart() {
        productsPage.goToCart();

        cartPage.clickCheckout();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, "https://www.saucedemo.com/cart.html", "User was navigated away from cart page");
    }
    @Test(priority = 4)
    public void testCheckoutWithAddedProduct(){
        productsPage.addFirstProductToCart();
        productsPage.goToCart();
        cartPage.clickCheckout();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/checkout-step-one.html");
    }

}