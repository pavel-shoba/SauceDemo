package steps;

import constructors.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static constants.IConstants.LOGIN_PAGE_URL;

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
        return this;
    }

    @Step("Login and add product to cart")
    public ProductsSteps loginAndAddProductToCart(User user, String productName) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user);
        productsPage.addProductToCart(productName);
        return this;
    }
}
