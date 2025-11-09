package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test
    public void validLoginShouldOpenProductsPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl);
        Assert.assertTrue(currentUrl.contains("inventory.html"),
                " لم يتم الانتقال إلى صفحة المنتجات بعد تسجيل الدخول!");
    }

    @Test
    public void invalidLoginShouldShowErrorMessage() {
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_password");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Epic sadface"),
                " لم تظهر رسالة الخطأ المتوقعة!");
    }
}
