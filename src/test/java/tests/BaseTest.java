package tests;

import steps.CartSteps;
import steps.LoginSteps;
import steps.ProductsSteps;
import pages.*;
import constants.IConstants;
import constants.ITestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IConstants, ITestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    HeaderPage headerPage;
    LoginPageFactory loginPageFactory;
    ProductsSteps productsSteps;
    LoginSteps loginSteps;
    CartSteps cartSteps;

    /**
     * This is initialization of pages
     */
    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        loginSteps = new LoginSteps(driver);
        productsSteps = new ProductsSteps(driver);
        cartSteps = new CartSteps(driver);
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}
