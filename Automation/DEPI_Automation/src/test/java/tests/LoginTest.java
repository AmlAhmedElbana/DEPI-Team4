package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataProviders;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "standardUser", dataProviderClass = DataProviders.class)
    public void validLoginShouldOpenProductsPage(String name, String password) {
        loginPage.login(name, password);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl);
        Assert.assertTrue(currentUrl.contains("inventory.html"),
                " لم يتم الانتقال إلى صفحة المنتجات بعد تسجيل الدخول!");
    }

    @Test(dataProvider = "problemUser", dataProviderClass = DataProviders.class)
    public void invalidLoginShouldShowErrorMessage(String name, String password) {

        loginPage.login(name, password);

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Epic sadface"),
                " لم تظهر رسالة الخطأ المتوقعة!");
    }
}
