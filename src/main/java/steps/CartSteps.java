package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HeaderPage;
import pages.LoginPage;
import pages.ProductsPage;

import static constants.IConstants.LOGIN_PAGE_URL;
@Log4j2
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
        log.info("The product {} was added in cart and open cart", productName);
        return this;
    }

    @Step("Add product to cart and delete from cart")
    public CartSteps addProductToCartAndDelete(String productName) {
        productsPage
                .addProductToCart(productName)
                .clickCartButton()
                .deleteItemFromCart(productName);
        log.info("The product {} was added in cart and delete from there", productName);
        return this;
    }

    @Step("Login and open empty cart")
    public CartSteps loginAndOpenEmptyCart(String username, String password) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(username, password);
        productsPage.clickCartButton();
        log.info("Opened cart page with empty state");
        return this;
    }
}
