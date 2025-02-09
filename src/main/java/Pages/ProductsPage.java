package Pages;

import Constructors.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static Constants.ITestConstants.SAUCE_LABS_BACKPACK;

public class ProductsPage extends HeaderPage {

    public static final By PRODUCTS_LIST = By.className("inventory_list");
    public static final By PRODUCT_NAME = By.xpath("//*[@data-test=\"inventory-item-name\"]");
    public static final By PRODUCT_DESCRIPTION = By.xpath("//*[@data-test=\"inventory-item-desc\"]");
    public static final By PRODUCT_PRICE = By.xpath("//*[@data-test=\"inventory-item-price\"]");
    public static final By PRODUCT_ADD_CART_BUTTON = By.xpath("//div[contains(text(), '" + SAUCE_LABS_BACKPACK + "')]/ancestor::div/div/button");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void checkProductsAvailability() {
        driver.findElement(PRODUCTS_LIST).isDisplayed();
    }

    public Product getDataFirstItem() {
        List<WebElement> productNames = driver.findElements(PRODUCT_NAME);
        List<WebElement> productDescs = driver.findElements(PRODUCT_DESCRIPTION);
        List<WebElement> productPrices = driver.findElements(PRODUCT_PRICE);
        String name = productNames.get(0).getText();
        String description = productDescs.get(0).getText();
        String price = productPrices.get(0).getText();
        return new Product(name, description, price);
    }

    public void addFirstItemInCart() {
        driver.findElement(PRODUCT_ADD_CART_BUTTON).click();
    }

    public void checkChangesNameButton() {
        WebElement addCartButton = driver.findElement(PRODUCT_ADD_CART_BUTTON);
        String nameRemoveButton = "Remove";
        Assert.assertTrue(addCartButton.getText().contains(nameRemoveButton), "Name is not changed");
    }
}
