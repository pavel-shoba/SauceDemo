package tests;

import constructors.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    /**
     * Tests to check product page
     */
    @Test(description = "QA-6 Check data of product")
    public void checkDataProductNotEmptyTest() {
        SoftAssertions softly = new SoftAssertions();
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(USERNAME, PASSWORD);
        Product product = productsPage.getProductByIndex(0);
        softly.assertThat(product).isNotNull().as("Product not found");
        softly.assertThat(product.getName()).isNotEmpty().as("Name is empty");
        softly.assertThat(product.getDescription()).isNotEmpty().as("Description is empty");
        softly.assertThat(product.getPrice()).isNotEmpty().as("Price is empty");
        softly.assertAll();
    }

    @Test(description = "QA-7 Add first item in cart")
    public void addProductInCartTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(USERNAME, PASSWORD);
        String productName = productsPage.getProductByIndex(0).getName();
        productsPage
                .addProductToCart(productName)
                .removeButtonIsVisible();
        Assert.assertEquals(headerPage.getProductsCountInCart(), "1");
    }
}
