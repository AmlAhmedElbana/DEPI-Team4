package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage {

    private WebDriver driver;


    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;


    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickCancel(){cancelButton.click();}

    public String getErrorMessage() {
        return errorMessage.getText();
    }

   ///  forward to Overview page
    public CheckoutOverviewPage fillInfoAndContinue(String fName, String lName, String pCode) {
        enterFirstName(fName);
        enterLastName(lName);
        enterPostalCode(pCode);
        clickContinue();
        return new CheckoutOverviewPage();
    }
}