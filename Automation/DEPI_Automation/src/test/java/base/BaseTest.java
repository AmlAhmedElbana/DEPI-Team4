package base;

import pages.CartPage;
import pages.CheckoutInfoPage;
import pages.LoginPage;
import pages.ProductsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutInfoPage checkoutInfoPage;

    private void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-features=PasswordLeakDetection");

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/v1/index.html");

        loginPage = new LoginPage(driver);
    }

    @BeforeMethod(onlyForGroups = {"loginRequired"})
    public void requiredSetup(){
        launchBrowser();
        productsPage = loginPage.loginAsStandardUser("standard_user", "secret_sauce");
        cartPage= new CartPage(driver);
        checkoutInfoPage= new CheckoutInfoPage(driver);
    }

    @BeforeMethod(onlyForGroups = {"noLoginRequired"})
    public void setup() {
       launchBrowser();
    }


    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}