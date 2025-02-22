package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Preconditions {
    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    /**
     * Here tests to check login and errors with different fields
     */
    @Test(description = "QA1 - This test login on site with empty username")
    public void loginWithEmptyUserNameTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "QA-2 This test login on site with empty password")
    public void loginWithEmptyPasswordTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_PASSWORD_ERROR);
    }

    @Test(description = "QA-3 This test login on site with empty username and password")
    public void loginWithEmptyFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(userWithEmptyFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "QA-4 This test login on site with incorrect username and password")
    public void loginWithIncorrectFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(userWithIncorrectFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS);
    }

    @Test(description = "QA-5 This test login on site with valid username and password")
    public void loginWithValidUserTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(user)
                .checkProductsAvailability();
    }

    /**
     * Tests are from another project for example
     */
    @Test
    public void loginWithoutPageFactory() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
        addButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
        deleteButton.click();
        addButton.click();
        deleteButton.click();
    }

    @Test
    public void loginWithPageFactory() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = loginPageFactory.getAddButton();
        addButton.click();
        WebElement deleteButton = loginPageFactory.getDeleteButton();
        deleteButton.click();
        addButton.click();
        deleteButton.click();
    }
}
