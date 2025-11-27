package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    private final By continueShoppingButton= By.id("continue-shopping");
    private final By checkoutButton=By.id("checkout");
    private final By removeBackpackButton=By.id("remove-sauce-labs-backpack");
    private final By firstItemName=By.className("inventory_item_name");
    private final By firstItemDesc= By.className("inventory_item_desc");
    private final By firstItemPrice= By.className("inventory_item_price");
    private final By itemTitleLink= By.id("item_4_title_link");

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
    public String getFirstItemDesc(){
        return driver.findElement(firstItemDesc).getText();
    }
    public String getFirstItemPrice(){
        return driver.findElement(firstItemPrice).getText();
    }
    public void clickItemLabel(){
        driver.findElement(itemTitleLink).click();
    }
}