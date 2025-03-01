package steps;

import constructors.User;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static constants.IConstants.LOGIN_PAGE_URL;
@Log4j2
public class ProductsSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductsSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Login and add product to cart")
    public ProductsSteps loginAndAddProductToCart(String userName, String password, String productName) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userName, password);
        productsPage.addProductToCart(productName);
        log.info("Entered by {}, {} and added product {} in cart", userName, password, productName);
        return this;
    }

    @Step("Login and add product to cart")
    public ProductsSteps loginAndAddProductToCart(User user, String productName) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user);
        productsPage.addProductToCart(productName);
        log.info("Entered using creds {} and added product {} in cart", user, productName);
        return this;
    }
}
