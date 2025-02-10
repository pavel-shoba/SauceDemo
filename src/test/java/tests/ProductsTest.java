package tests;

import constructors.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test(description = "QA-6 Check data of product")
    public void checkDataProducts() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        Product product = productsPage.getDataItem(0);
        Assert.assertNotNull(product, "Product not found");
        Assert.assertFalse(product.getName().isEmpty(), "Name is empty");
        Assert.assertFalse(product.getDescription().isEmpty(), "Description is empty");
        Assert.assertFalse(product.getPrice().isEmpty(), "Price is empty");
    }

    @Test(description = "QA-7 Add first item in cart")
    public void addProductInCart() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        String productName = productsPage.getDataItem(0).getName();
        productsPage.addProductToCart(productName);
        productsPage.removeButtonIsVisible();
        Assert.assertEquals(headerPage.getProductsCountInCart(), "1");
    }
}
