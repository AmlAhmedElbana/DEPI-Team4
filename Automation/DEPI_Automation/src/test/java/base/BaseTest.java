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

        // 1. الحل السحري: فتح المتصفح في وضع "المتصفح المتخفي"
        // ده بيمنع كروم إنه يحفظ أي هيستوري أو كوكيز أو يشيك على الباسوردات
        options.addArguments("--incognito");

        // 2. زيادة تأكيد: وضع الضيف (بيمنع تحميل أي بروفايل شخصي)
        options.addArguments("--guest");

        // 3. قفل كل خدمات المزامنة والترجمة والإضافات اللي ممكن تطلع نوافذ
        options.addArguments("--disable-sync");
        options.addArguments("--disable-translate");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-notifications");

        // 4. محاولة إضافية لقفل مدير الباسوردات (لو Incognito مش كفاية)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // 5. استبعاد سويتش "Enable Automation" (عشان يخفي الشريط الأصفر)
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // 6. ضمان إن الصفحة تحمل بالكامل
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


    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}