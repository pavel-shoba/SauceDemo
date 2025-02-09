package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends HeaderPage {

    public static final By CART_ITEM = By.xpath("//*[@data-test='inventory-item']");
    public static final By REMOVE_BUTTON = By.xpath("//*[contains(text(),'Remove')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean checkEmptyCart() {
        List<WebElement> items = driver.findElements(CART_ITEM);
        return items.isEmpty();
    }

    public void deleteItemFromCart() {
        driver.findElement(REMOVE_BUTTON).click();
    }
}
