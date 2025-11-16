package base;

import pages.CartPage;
import pages.CheckoutInfoPage;
import pages.LoginPage;
import pages.ProductsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutInfoPage checkoutInfoPage;


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/v1/index.html");

        loginPage = new LoginPage(driver);

        productsPage = loginPage.login("standard_user", "secret_sauce");

        cartPage = new CartPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);


    }


    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}