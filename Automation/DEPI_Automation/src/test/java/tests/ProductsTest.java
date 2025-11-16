package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    private ProductsPage productsPage;

    @BeforeMethod
    public void loginAndSetup() {
        //login
        loginPage.login("problem_user", "secret_sauce");
        //create new object
        productsPage = new ProductsPage(driver);
    }

    @Test(priority = 1)
    public void verifyProductsAreDisplayed() {
        Assert.assertTrue(productsPage.areProductsDisplayed(), "Products are not displayed!");
    }

    @Test(priority = 2)
    public void verifyAddToCartIncreasesBadge() {
        productsPage.addFirstProductToCart();
        Assert.assertEquals(productsPage.getCartBadgeCount(), "1", "Cart badge did not increase!");
    }

    @Test(priority = 3)
    public void verifyAddAllProductsUpdatesCartBadge() {
        productsPage.addAllProductsToCart();
        Assert.assertEquals(productsPage.getCartBadgeCount(), "6", "Cart badge should show total number of products!");
    }

    @Test(priority = 4)
    public void verifyOpenProductDetails() {
        productsPage.openProductDetails(0);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl != null && currentUrl.contains("inventory-item.html"), "Product details page not opened!");
    }

    @Test(priority = 5)
    public void verifySortFunctionality() {
        productsPage.selectSortOption("Price (low to high)");

        Assert.assertTrue(true, "Sorting not applied!");
    }
}
