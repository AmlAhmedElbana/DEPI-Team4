package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataProviders;

@Test(groups = {"noLoginRequired"})
public class LoginTest extends BaseTest {

    @Test(priority = 1, dataProvider = "standardUser", dataProviderClass = DataProviders.class)
    public void validLoginShouldOpenProductsPage(String username, String password) {
        loginPage.login(username, password);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl, "URL should not be null");
        Assert.assertTrue(currentUrl.contains("inventory.html"),
                "User should be redirected to Products page after valid login.");
    }


    @Test(priority = 2, dataProvider = "lockedOutUser", dataProviderClass = DataProviders.class)
    public void lockedOutUserShouldShowErrorMessage(String username, String password) {
        loginPage.login(username, password);

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Epic sadface"),
                "Expected error message for locked-out user.");
    }


    @Test(priority = 3)
    public void loginWithInvalidUsername() {
        loginPage.login("wrong_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"),
                "Error message should appear for invalid username.");
    }

    @Test(priority = 4)
    public void loginWithInvalidPassword() {
        loginPage.login("standard_user", "wrong_password");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"),
                "Error message should appear for invalid password.");
    }


    @Test(priority = 5)
    public void loginWithEmptyUsername() {
        loginPage.login("", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"),
                "Error message for empty username should be shown.");
    }

    @Test(priority = 6)
    public void loginWithEmptyPassword() {
        loginPage.login("standard_user", "");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"),
                "Error message for empty password should be shown.");
    }

    @Test(priority = 7)
    public void loginWithEmptyUsernameAndPassword() {
        loginPage.login("", "");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"),
                "Error message should appear when both fields are empty.");
    }


    @Test(priority = 8)
    public void loginUsernameTrimSpaces() {

        loginPage.login("  standard_user  ", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();

        boolean loginSuccess = currentUrl.contains("inventory.html");
        boolean errorDisplayed = false;

        if (!loginSuccess) {
            try {
                errorDisplayed = !loginPage.getErrorMessage().isEmpty();
            } catch (Exception e) {
                errorDisplayed = false;
            }
        }

        Assert.assertTrue(loginSuccess || errorDisplayed,
                "System should verify login attempt with spaces.");
    }


    @Test(priority = 9)
    public void passwordFieldShouldBeMasked() {
        String fieldType = loginPage.getPasswordFieldType();
        Assert.assertEquals(fieldType, "password",
                "Password field attribute 'type' should be 'password' to mask characters.");
    }
}