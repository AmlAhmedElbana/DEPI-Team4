package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage {
    private final WebDriver driver;


    private final By successHeader = By.className("complete-header");
    private final By successText = By.className("complete-text");
    private final By backHomeButton = By.id("back-to-products"); // في النسخة القديمة ممكن يكون كلاس بس، هنجرب ID الأول
    private final By ponyExpressImage = By.className("pony_express");


    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }


    public String getSuccessHeaderText() {
        return driver.findElement(successHeader).getText();
    }

    public String getSuccessMessageText() {
        return driver.findElement(successText).getText();
    }

    public boolean isPonyExpressImageDisplayed() {
        return driver.findElement(ponyExpressImage).isDisplayed();
    }

    public ProductsPage clickBackHome() {

        driver.findElement(backHomeButton).click();
        return new ProductsPage(driver);
    }
}