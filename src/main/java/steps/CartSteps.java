package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HeaderPage;
import pages.LoginPage;
import pages.ProductsPage;

import static constants.IConstants.LOGIN_PAGE_URL;

public class CartSteps {
    private ProductsPage productsPage;
    private CartPage cartPage;
    private HeaderPage headerPage;
    private LoginPage loginPage;

    public CartSteps (WebDriver driver) {
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Step("Add product to cart and open cart")
    public CartSteps addProductToCartAndOpen(String productName) {
        productsPage
                    .addProductToCart(productName)
                    .clickCartButton();
        return this;
    }

    @Step("Add product to cart and delete from cart")
    public CartSteps addProductToCartAndDelete(String productName) {
        productsPage
                .addProductToCart(productName)
                .clickCartButton()
                .deleteItemFromCart(productName);
        return this;
    }

    @Step("Login and open empty cart")
    public CartSteps loginAndOpenEmptyCart(String username, String password) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(username, password);
        productsPage.clickCartButton();
        return this;
    }
}
