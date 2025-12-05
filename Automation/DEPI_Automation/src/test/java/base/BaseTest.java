package base;
import constants.FrameworkConstants;
import pages.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutInfoPage checkoutInfoPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;

    private void launchBrowser() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");


        //options.addArguments("--guest");


        options.addArguments("--disable-sync");
        options.addArguments("--disable-translate");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-notifications");


        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs", prefs);


        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});


        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FrameworkConstants.timeOut);
        driver.get("https://www.saucedemo.com/v1/index.html");

        loginPage = new LoginPage(driver);
    }

    @BeforeMethod(onlyForGroups = {"loginRequired"})
    public void requiredSetup(){
        launchBrowser();
        productsPage = loginPage.loginAsStandardUser("standard_user", "secret_sauce");

        cartPage= new CartPage(driver);
        checkoutInfoPage= new CheckoutInfoPage(driver);
        checkoutOverviewPage= new CheckoutOverviewPage(driver);
        checkoutCompletePage= new CheckoutCompletePage(driver);
    }

    @BeforeMethod(onlyForGroups = {"noLoginRequired"})
    public void setup() {
       launchBrowser();
    }


    public WebDriver getDriver() {
        return driver;
    }


    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}