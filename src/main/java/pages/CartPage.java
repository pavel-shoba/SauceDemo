package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HeaderPage {
    public static final By CART_ITEM = By.xpath("//*[@data-test='inventory-item']");
    public By REMOVE_BUTTON;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isCartEmpty() {
        return driver.findElements(CART_ITEM).isEmpty();
    }

    public void deleteItemFromCart(String productName) {
        REMOVE_BUTTON = By.xpath("//div[contains(text(),'" + productName + "')]/ancestor::div//button[contains(text(), 'Remove')]");
        driver.findElement(REMOVE_BUTTON).click();
    }
}
