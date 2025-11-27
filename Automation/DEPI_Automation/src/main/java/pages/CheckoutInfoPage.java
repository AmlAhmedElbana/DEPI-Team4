package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import constants.FrameworkConstants;

public class CheckoutInfoPage {

    private final WebDriver driver;

    private final By firstNameField= By.id("first-name");
    private final By lastNameField=By.id("last-name");
    private final By postalCodeField=By.id("postal-code");
    private final By continueButton=By.id("continue");
    private final By cancelButton=By.id("cancel");
    private final By errorMessage= By.cssSelector("h3[data-test='error']");
    private final By cartIcon= By.id("shopping_cart_container");

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue() {
        driver.manage().timeouts().implicitlyWait(FrameworkConstants.timeOut);
        driver.findElement(continueButton).click();
    }

    public void clickCancel(){driver.findElement(cancelButton).click();}

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }


    public CheckoutOverviewPage fillInfoAndContinue(String fName, String lName, String pCode) {
        enterFirstName(fName);
        enterLastName(lName);
        enterPostalCode(pCode);
        clickContinue();
        return new CheckoutOverviewPage(driver);
    }

    public CartPage clickCart(){
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }

}