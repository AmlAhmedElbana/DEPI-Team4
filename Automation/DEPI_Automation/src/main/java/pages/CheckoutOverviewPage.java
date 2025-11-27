package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    private final WebDriver driver;


    private final By productName = By.className("inventory_item_name");
    private final By productPrice = By.className("inventory_item_price");
    private final By summarySubtotal = By.className("summary_subtotal_label");
    private final By summaryTax = By.className("summary_tax_label");
    private final By summaryTotal = By.className("summary_total_label");
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");


    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }



    public String getDisplayedProductName() {
        return driver.findElement(productName).getText();
    }

    public String getDisplayedProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public String getSubtotalLabel() {
        return driver.findElement(summarySubtotal).getText();
    }

    public String getTotalLabel() {
        return driver.findElement(summaryTotal).getText();
    }

    public CheckoutCompletePage clickFinish() {
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver);
    }

    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }
}