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
        Assert.assertTrue(cartPage.checkEmptyCart(), "Cart is not empty");
    }

    @Test(description = "QA-9 Add item in cart and delete")
    public void addItemAndDeleteFromCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addFirstItemInCart();
        headerPage.clickCartButton();
        Assert.assertEquals(headerPage.getCountItemInCart(), "1");
        Assert.assertFalse(cartPage.checkEmptyCart(), "Cart is empty");
        cartPage.deleteItemFromCart();
        Assert.assertTrue(headerPage.isBadgeVisible(), "Badge is not empty");
        Assert.assertTrue(cartPage.checkEmptyCart(), "Cart is not empty");
    }
}
