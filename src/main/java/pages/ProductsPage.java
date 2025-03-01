package pages;

import constructors.Product;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.NoSuchElementException;

@Log4j2
public class ProductsPage extends HeaderPage {
    public static final By PRODUCTS_LIST = By.className("inventory_list");
    public static final By PRODUCT_NAME = By.xpath("//*[@data-test=\"inventory-item-name\"]");
    public static final By PRODUCT_DESCRIPTION = By.xpath("//*[@data-test=\"inventory-item-desc\"]");
    public static final By PRODUCT_PRICE = By.xpath("//*[@data-test=\"inventory-item-price\"]");
    public static final By REMOVE_PRODUCT_BUTTON = By.xpath("//*[contains(text(),'Remove')]");
    private String productAddCartButton = "//div[contains(text(), '%s')]/ancestor::div/div/button";;

    /**
     * Method to initialize driver for Products page
     */
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to check products are visible on page
     */
    public boolean checkProductsAvailability() {
        try {
            return driver.findElement(PRODUCTS_LIST).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Method to get product by index
     */
    public Product getProductByIndex(int index) {
        List<WebElement> productNames = driver.findElements(PRODUCT_NAME);
        List<WebElement> productDescs = driver.findElements(PRODUCT_DESCRIPTION);
        List<WebElement> productPrices = driver.findElements(PRODUCT_PRICE);
        String name = productNames.get(index).getText();
        String description = productDescs.get(index).getText();
        String price = productPrices.get(index).getText();
        return new Product(name, description, price);
    }

    /**
     * Method to add product to cart
     */
    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(productAddCartButton, productName))).click();
        log.info("The product {} was added in cart", productName);
        return this;
    }

    /**
     * Method to check that "Remove" button is visible
     */
    public boolean removeButtonIsVisible() {
        try {
            return driver.findElement(REMOVE_PRODUCT_BUTTON).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
