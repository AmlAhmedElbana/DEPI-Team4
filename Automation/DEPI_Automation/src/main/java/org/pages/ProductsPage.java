package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private final WebDriver driver;

    private final By productTitle = By.className("inventory_item_name");
    private final By addToCartButtons = By.cssSelector(".btn_inventory");
    private final By cartBadge = By.className("shopping_cart_badge");
    private By cartIcon = By.className("shopping_cart_link");
    private final By sortDropdown = By.className("product_sort_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean areProductsDisplayed() {
        List<WebElement> products = driver.findElements(productTitle);
        return !products.isEmpty();
    }

    public void addFirstProductToCart() {
        driver.findElements(addToCartButtons).getFirst().click();
    }

    public void addAllProductsToCart() {
        for (WebElement btn : driver.findElements(addToCartButtons)) {
            btn.click();
        }
    }

    public String getCartBadgeCount() {
        try {
            return driver.findElement(cartBadge).getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public void openProductDetails(int index) {
        driver.findElements(productTitle).get(index).click();
    }

    public void selectSortOption(String value) {
        driver.findElement(sortDropdown).sendKeys(value);
    }

    public By getCartIcon() {
        return cartIcon;
    }

    public void setCartIcon(By cartIcon) {
        this.cartIcon = cartIcon;
    }
}
