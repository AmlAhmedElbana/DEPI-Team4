package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage {
    private final WebDriver driver;

    private final By productTitlesLoc = By.className("inventory_item_name");
    private final By addToCartButtonsLoc = By.cssSelector(".btn_inventory");
    private final By cartBadgeLoc = By.className("shopping_cart_badge");
    private final By cartIconLoc = By.className("shopping_cart_link");
    private final By sortDropdownLoc = By.className("product_sort_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean areProductsDisplayed() {
        List<WebElement> titles = driver.findElements(productTitlesLoc);
        return !titles.isEmpty();
    }

    public void addFirstProductToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtonsLoc);
        if (!buttons.isEmpty()) {
            buttons.get(0).click();
        }
    }

    public void addAllProductsToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtonsLoc);
        for (WebElement btn : buttons) {
            btn.click();
        }
    }

    public String getCartBadgeCount() {
        try {
            return driver.findElement(cartBadgeLoc).getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public void openProductDetails(int index) {
        List<WebElement> titles = driver.findElements(productTitlesLoc);
        titles.get(index).click();
    }

    public void selectSortOption(String visibleText) {
        WebElement dropdownElement = driver.findElement(sortDropdownLoc);
        Select sorter = new Select(dropdownElement);
        sorter.selectByVisibleText(visibleText);
    }

    public WebElement getCartIcon() {
        return driver.findElement(cartIconLoc);
    }

    public CartPage goToCart(){
        driver.findElement(cartIconLoc).click();
        return new CartPage(driver);
    }
}