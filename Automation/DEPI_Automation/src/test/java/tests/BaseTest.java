package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.pages.DriverFactory;
import org.pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // استخدام DriverFactory بدل ما نعمل ChromeDriver مباشرة
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");

        // إنشاء صفحة اللوجين وتمرير الدرايفر ليها
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
