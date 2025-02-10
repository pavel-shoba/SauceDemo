package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{
    @Test(description = "QA-8 Check empty state for cart")
    public void checkEmptyCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        headerPage.clickCartButton();
        Assert.assertTrue(headerPage.isBadgeVisible(), "Badge is not empty");
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty");
    }

    @Test(description = "QA-9 Add product to cart")
    public void checkAddingProductToCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        String productName = productsPage.getDataItem(0).getName();
        productsPage.addProductToCart(productName);
        headerPage.clickCartButton();
        Assert.assertEquals(headerPage.getProductsCountInCart(), "1");
        Assert.assertFalse(cartPage.isCartEmpty(), "Cart is empty");
        Assert.assertFalse(productName.isEmpty(), "Name is empty");
    }

    @Test(description = "QA-10 Delete product from cart")
    public void checkDeletingProductFromCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        String productName = productsPage.getDataItem(0).getName();
        productsPage.addProductToCart(productName);
        headerPage.clickCartButton();
        cartPage.deleteItemFromCart(productName);
        Assert.assertTrue(headerPage.isBadgeVisible(), "Badge is not empty");
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty");
    }
}
