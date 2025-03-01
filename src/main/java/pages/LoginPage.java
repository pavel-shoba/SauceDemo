package pages;

import constructors.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@Log4j2
public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    /**
     * Method to initialize driver for Login page
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to make login using username and password from odject User, and return Product page
     */
    public ProductsPage login(User user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user.getUsername());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Filled fields by creds {} and clicked login button", user);
        return new ProductsPage(driver);
    }

    /**
     * Method to make login using username and password from constants, and return Product page
     */
    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Filled fields by username={}, password={} and clicked login button", username, password);
        return new ProductsPage(driver);
    }

    /**
     * Method to return error message
     */
    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    /**
     * Waiter while page will be opened
     */
    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        log.info("Page was loaded and login button is displayed");
        return this;
    }
}
