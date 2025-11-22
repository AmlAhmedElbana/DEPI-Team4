package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    private final By continueShoppingButton= By.id("continue-shopping");
    private final By checkoutButton=By.id("checkout");
    private final By removeBackpackButton=By.id("remove-sauce-labs-backpack");
    private final By firstItemName=By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public ProductsPage clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
        return new ProductsPage(driver);
    }

    public void removeFirstItem() {

        driver.findElement(removeBackpackButton).click();
    }

    public CheckoutInfoPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return new CheckoutInfoPage(driver);
    }

    public String getFirstItemName() {
        return driver.findElement(firstItemName).getText();
    }
}