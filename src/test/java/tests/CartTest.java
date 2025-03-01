package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    SoftAssertions softly = new SoftAssertions();
    /**
     * Here tests to check cart
     */
    @Test(description = "QA-8 Check empty state for cart")
    public void checkEmptyCart() {
        cartSteps.loginAndOpenEmptyCart(USERNAME, PASSWORD);
        softly.assertThat(headerPage.isBadgeVisible()).isTrue().as("Badge is not visible");
        softly.assertThat(cartPage.isCartEmpty()).isTrue().as("Cart is not empty");
        softly.assertAll();
    }

    @Test(description = "QA-9 Add product to cart")
    public void checkAddingProductToCart() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        String productName = productsPage.getProductByIndex(0).getName();
        cartSteps.addProductToCartAndOpen(productName);
        softly.assertThat(headerPage.getProductsCountInCart()).isEqualTo("1");
        softly.assertThat(cartPage.isCartEmpty()).isFalse();
        softly.assertThat(productName).isNotEmpty();
        softly.assertAll();
    }

    @Test(description = "QA-10 Delete product from cart")
    public void checkDeletingProductFromCart() {
        loginSteps.loginAndWaitForPageOpened(USERNAME, PASSWORD);
        String productName = productsPage.getProductByIndex(0).getName();
        cartSteps.addProductToCartAndDelete(productName);
        softly.assertThat(headerPage.isBadgeVisible()).isTrue().as("Badge is not visible");
        softly.assertThat(cartPage.isCartEmpty()).isTrue().as("Cart is not empty");
        softly.assertAll();
    }
}
