package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;


    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackButton;

    @FindBy(className = "inventory_item_name")
    private WebElement firstItemName;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public ProductsPage clickContinueShopping() {
        continueShoppingButton.click();
        return new ProductsPage(driver);
    }

    public void removeFirstItem() {

        removeBackpackButton.click();
    }
    /// forward to checkoutinfo
    public CheckoutInfoPage clickCheckout() {
        checkoutButton.click();
        return new CheckoutInfoPage(driver);
    }

    public String getFirstItemName() {
        return firstItemName.getText();
    }
}