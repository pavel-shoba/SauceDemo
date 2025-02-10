package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    @Test(description = "QA1 - This test login on site with empty username")
    public void loginWithEmptyUserNameTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "QA-2 This test login on site with empty password")
    public void loginWithEmptyPasswordTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_PASSWORD_ERROR);
    }

    @Test(description = "QA-3 This test login on site with empty username and password")
    public void loginWithEmptyFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "QA-4 This test login on site with incorrect username and password")
    public void loginWithIncorrectFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("sadf", "asdf");
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS);
    }

    @Test(description = "QA-5 This test login on site with valid username and password")
    public void loginWithValidUser() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.checkProductsAvailability();
    }
}
