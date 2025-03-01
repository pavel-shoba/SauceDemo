package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends HeaderPage {
    public static final By CART_ITEM = By.xpath("//*[@data-test='inventory-item']");
    private String removeButton = "//div[contains(text(),'%s')]/ancestor::div//button[contains(text(), 'Remove')]";;

    /**
     * Method to initialize driver for Cart page
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to return on empty item
     */
    public Boolean isCartEmpty() {
        return driver.findElements(CART_ITEM).isEmpty();
    }

    /**
     * Method to delete item from cart
     */
    public void deleteItemFromCart(String productName) {
        driver.findElement(By.xpath(String.format(removeButton, productName))).click();
        log.info("Deleted product {} from cart ", productName);
    }
}
