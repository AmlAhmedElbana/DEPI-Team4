package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    private final WebDriver driver;


    @FindBy(className = "inventory_item_name")
    private List<WebElement> productTitles;

    @FindBy(css = ".btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean areProductsDisplayed() {

        return !productTitles.isEmpty();
    }
    // Add a product to cart, to be used in other test pages
    public void addFirstProductToCart() {
        addToCartButtons.get(0).click();
    }

    public void addAllProductsToCart() {
        for (WebElement btn : addToCartButtons) {
            btn.click();
        }
    }

    public String getCartBadgeCount() {
        try {
            return cartBadge.getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public void openProductDetails(int index) {
        productTitles.get(index).click();
    }

    public void selectSortOption(String value) {
        sortDropdown.sendKeys(value);
    }

    public WebElement getCartIcon() {
        return cartIcon;
    }
    // to be used in other test pages
    public CartPage goToCart(){
        cartIcon.click();
        return new CartPage(driver);
    }

}