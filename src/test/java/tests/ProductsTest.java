package tests;

import Constructors.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test(description = "QA-6 Check data of product")
    public void checkDataProducts() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        Product product = productsPage.getDataFirstItem();
        Assert.assertNotNull(product, "Product not found");
        Assert.assertFalse(product.getName().isEmpty(), "Name is empty");
        Assert.assertFalse(product.getDescription().isEmpty(), "Description is empty");
        Assert.assertFalse(product.getPrice().isEmpty(), "Price is empty");
    }

    @Test(description = "QA-7 Add first item in cart")
    public void addItemInCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addFirstItemInCart();
        productsPage.checkChangesNameButton();
        Assert.assertEquals(headerPage.getCountItemInCart(), "1");
    }
}
